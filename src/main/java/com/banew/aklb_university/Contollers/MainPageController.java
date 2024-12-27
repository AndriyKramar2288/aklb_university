package com.banew.aklb_university.Contollers;

import com.banew.aklb_university.DTO.UserRegistration;
import com.banew.aklb_university.entities.Publication;
import com.banew.aklb_university.entities.User;
import com.banew.aklb_university.repositories.PublicationRepository;
import com.banew.aklb_university.repositories.UserRepository;
import jakarta.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping(path = "/")
@Controller
public class MainPageController {
    private PublicationRepository publicationRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public MainPageController(
            PublicationRepository publicationRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.publicationRepository = publicationRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String HomePage(Model model) {
        model.addAttribute("recent_publication", publicationRepository.recentPublication(4));
        return "main";
    }

    @GetMapping("/login")
    public String loginPage(Model model, @RequestParam(name = "error", defaultValue = "false") boolean error) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("customForm", new UserRegistration());
        return "register";
    }
    
    @GetMapping("/user")
    public String userPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "user";
    }
    

    @PostMapping("/register")
    public String registerPostPage(@ModelAttribute("customForm") @Valid UserRegistration customForm, Errors errors) throws Exception {
        if (errors.hasErrors()) {
            return "register";
        }
        else {
            userRepository.save(customForm.toUser(passwordEncoder));
            return "redirect:/login";
        }   
    }
    

    @PostMapping(path = "/create")
    public String CreatePublication(@RequestParam(name = "negro") String name) {

        var publication = new Publication();
        publication.setTitle(name);
        publicationRepository.save(publication);

        return "main";
    }
}

package com.banew.aklb_university.Contollers;

import com.banew.aklb_university.entities.Publication;
import com.banew.aklb_university.repositories.PublicationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping(path = "/")
@Controller
public class MainPageController {
    private PublicationRepository publicationRepository;

    public MainPageController(
            PublicationRepository publicationRepository
    ) {
        this.publicationRepository = publicationRepository;
    }

    @GetMapping
    public String HomePage(Model model) {
        model.addAttribute("recent_publication", publicationRepository.recentPublication(4));
        return "main";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    
    // @GetMapping("/login/forget-password")
    // public String forgetPassword() {
    //     return new String();
    // }
    
    

    @PostMapping(path = "/create")
    public String CreatePublication(@RequestParam(name = "negro") String name) {

        var publication = new Publication();
        publication.setTitle(name);
        publicationRepository.save(publication);

        return "main";
    }
}

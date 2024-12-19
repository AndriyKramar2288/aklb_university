package com.banew.aklb_university.Contollers;

import com.banew.aklb_university.entities.Publication;
import com.banew.aklb_university.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequestMapping(path = "/home")
@Controller
public class MainPageController {
    private PublicationRepository publicationRepository;

    @Autowired
    public MainPageController(
            PublicationRepository publicationRepository
    ) {
        this.publicationRepository = publicationRepository;
    }

    @GetMapping
    public String HomePage(Model model) {
        var aboba = new Publication();
        aboba.setTitle("ASDDDDDD");

        model.addAttribute("recent_publication", publicationRepository.findAll());
        return "index_mymy";
    }

    @PostMapping(path = "/create")
    public String CreatePublication(@RequestParam(name = "negro") String name) {

        var publication = new Publication();
        publication.setTitle(name);
        publicationRepository.save(publication);

        return "index_mymy";
    }

//    @ModelAttribute(name = "recent_publication")
//    List<Publication> recentPublication() {
//        List<Publication> publications = new ArrayList<Publication>();
//        if (publications.size() > 0) {
//            publicationRepository.findAll().forEach(x -> { publications.add(x); });
//            publications.sort(Comparator.comparing(Publication::getDate).reversed());
//            return publications.subList(0, 4);
//        }
//        else
//            return publications;
//    }
}

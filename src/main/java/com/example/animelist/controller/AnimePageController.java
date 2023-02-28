package com.example.animelist.controller;


import com.example.animelist.entity.Anime;
import com.example.animelist.service.AnimeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AnimePageController {

    @Autowired
    private AnimeSearchService aService;
    String title = "title.animeNotFound";


    @GetMapping("/anime/{name}")
    public String animeWatchPage(@PathVariable("name") String name, Model model) {
        Optional<Anime> animeOptional = aService.findByName(name);
        if (animeOptional.isEmpty()) {
            model.addAttribute("name", name);
            model.addAttribute("title", title);
            return "error_page.html";
        }
    }
}

package com.example.animelist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimePageController {
    @GetMapping("/anime")
    public String animePage(Model model) {
    return "anime_page.html";
    }
}

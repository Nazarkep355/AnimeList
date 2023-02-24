package com.example.animelist.controller;

import com.example.animelist.entity.Anime;
import com.example.animelist.entity.SavedList;
import com.example.animelist.repos.AnimeRepository;
import com.example.animelist.repos.UserRepository;
import com.example.animelist.service.AnimeSearchService;
import com.example.animelist.service.UserRateService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainPageController {
    String firstListName = "firstPageList";
    @Autowired
    private AnimeSearchService animeSearchService;


    @GetMapping("/")
    public String redirectTo(Model model) {
        SavedList savedList= animeSearchService.findSavedListByName(firstListName).get();
        List<Anime> animeList = savedList.getAnimeList();
        model.addAttribute(firstListName,animeList);
        return "anime_list_page.html";
    }


    @PostMapping("/log")
    public String login() {
        return "redirect:/";
    }


}

package com.example.animelist.controller;

import com.example.animelist.entity.Anime;
import com.example.animelist.service.AnimeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAnimeController {
    @Autowired
    private AnimeSearchService animeSearchService;


    @GetMapping("/search/{name}")
    public Page<Anime> getAnimeByName(@PathVariable("name") String name, Pageable pageable) {
//        System.out.println("name:"+name);
        return animeSearchService.findAnimeByName(name, pageable);
    }


}

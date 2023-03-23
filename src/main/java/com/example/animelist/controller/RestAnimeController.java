package com.example.animelist.controller;

import com.example.animelist.entity.Anime;
import com.example.animelist.service.AnimeSearchService;
import com.example.animelist.service.UserRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RestAnimeController {
    @Autowired
    private AnimeSearchService animeSearchService;

    @Autowired
    private UserRateService userRateService;

    @GetMapping("/search/{name}")
    public Page<Anime> getAnimeByName(@PathVariable("name") String name, Pageable pageable) {
        Page<Anime> page =animeSearchService.findAnimeByName(name, pageable);
        page.getContent().forEach(anime->anime.setCharacters(null));
        return page;
    }

    @GetMapping(value = "/best")
    public List<Anime> getBestByRating(int quantity) {
        List<Anime> anime = userRateService.topRating(quantity);
        anime.forEach(a->a.setCharacters(null));
        return anime;
    }

    @GetMapping("/rating/{id}")
    public Double getRate(@PathVariable("id") long id) {
        return userRateService.getAnimeRate(id);
    }


}

package com.example.animelist.controller;

import com.example.animelist.entity.Anime;
import com.example.animelist.service.AnimeSearchService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserRestController {
    @Autowired
    private AnimeSearchService animeSearchService;

//    @GetMapping("/test")
//    public Anime testMapping() {
//        return animeSearchService.findByName("Kaguya-sama: Love is War").get();
//    }

    @PostMapping("/user/addToWatchList")
    public ResponseEntity<Anime> addAnimeToUserList(Long anime_id, HttpServletRequest request) {
        System.out.println("here");
        System.out.println(request.getRemoteUser());
        System.out.println(anime_id);
        return ResponseEntity.ok(null);
    }
}

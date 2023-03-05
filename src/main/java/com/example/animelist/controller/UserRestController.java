package com.example.animelist.controller;

import com.example.animelist.entity.Anime;
import com.example.animelist.service.AnimeSearchService;
import com.example.animelist.service.UserRateService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private AnimeSearchService animeSearchService;
    @Autowired
    private UserRateService userRateService;


    @PostMapping("/addToWatchList")
    public ResponseEntity<Anime> addAnimeToUserList(Long anime_id, HttpServletRequest request) {
        Optional<Anime> animeOptional = animeSearchService.findAnimeById(anime_id);
        if(animeOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        String email = request.getRemoteUser();
        userRateService.addToWatchList(email,animeOptional.get());
        return ResponseEntity.ok(null);
    }
    @PostMapping("/rateAnime")
    public ResponseEntity setAnimeRate(Long anime_id,HttpServletRequest request,int score){
        if(anime_id>10){
            return ResponseEntity.notFound().build();
        }
        System.out.println("id: " +anime_id);
        System.out.println("score: "+score);
        return ResponseEntity.ok().build();
    }
}

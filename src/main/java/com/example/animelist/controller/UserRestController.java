package com.example.animelist.controller;

import com.example.animelist.entity.Anime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserRestController {
    @PostMapping("/addToWatchList")
    public ResponseEntity<Anime> addAnimeToUserList(Long anime_id, String user) {
        return ResponseEntity.ok(null);
    }
}

package com.example.animelist.controller;

import com.example.animelist.entity.Anime;
import com.example.animelist.service.AnimeSearchService;
import com.example.animelist.service.UploadFileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class UserRestController {
    @Autowired
    private AnimeSearchService animeSearchService;
    @Autowired
    private UploadFileService uploadFileService;

//    @GetMapping("/test")
//    public Anime testMapping() {
//        return animeSearchService.findByName("Kaguya-sama: Love is War").get();
//    }
    @PostMapping("/user/upload")
    public ResponseEntity saveFile(MultipartFile file){
        uploadFileService.saveFile(file);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/user/upload")
    public String uploadPage(){
        return "upload_page.html";
    }
    @PostMapping("/user/addToWatchList")
    public ResponseEntity<Anime> addAnimeToUserList(Long anime_id, HttpServletRequest request) {
        System.out.println("here");
        System.out.println(request.getRemoteUser());
        return ResponseEntity.ok(null);
    }
}

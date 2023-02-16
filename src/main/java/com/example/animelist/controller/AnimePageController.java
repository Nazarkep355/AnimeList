package com.example.animelist.controller;

import com.example.animelist.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AnimePageController {



    @Autowired
    private UploadFileService fileService;

    @GetMapping("/")
    public String redirectTo() {
        return "anime_page.html";
    }

    @PostMapping("/upload")
    public ResponseEntity upload(MultipartFile file){
        fileService.saveFile(file);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/log")
    public String login() {
        return "redirect:/";
    }


}

package com.example.animelist.controller;

import com.example.animelist.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RecordService recordService;
    @GetMapping("/upload")
    public String uploadEpisode(){

        System.out.println(recordService.getLastRecordIdIncremented());
        return "upload_page.html";
    }
    @PostMapping("/upload")
    public ResponseEntity uploadEpisode(String anime, int episode_num, MultipartFile file){
        recordService.uploadEpisode(anime,episode_num,file);
        return ResponseEntity.ok(null);
    }
}

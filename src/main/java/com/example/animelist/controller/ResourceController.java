package com.example.animelist.controller;

import com.example.animelist.service.StreamingVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ResourceController {
    @Autowired
    private StreamingVideoService videoService;



    @GetMapping("/video/{name}")
    public Mono<Resource> getVideo(@PathVariable("name") String name) {
        return videoService.getVideo(name);
    }
}

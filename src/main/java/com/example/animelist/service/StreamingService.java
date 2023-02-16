package com.example.animelist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {
    @Value("${download.folder}")
    private String path;
    @Autowired
    private ResourceLoader resourceLoader;


    public Mono<Resource> getVideo(String title){
        return Mono.fromSupplier(()->resourceLoader
                .getResource(path+"/Videos/"+title));
    }
}

package com.example.animelist.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadFileService {
    public String saveFile(MultipartFile file){
        try {
            file.transferTo(new File("C:/ANIME/Videos/"+file.getOriginalFilename()));
            return file.getOriginalFilename();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

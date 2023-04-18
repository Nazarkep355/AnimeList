package com.example.animelist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadFileService {
    @Value("${download.folder}")
    private String path;

    public String saveFile(MultipartFile file,String newName) {
        try {
            file.transferTo(new File(path+"Videos/" + newName));
            return file.getOriginalFilename();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

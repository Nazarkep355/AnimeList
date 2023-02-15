package com.example.animelist.controller;

import com.example.animelist.repos.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Enumeration;

@Controller
public class AnimePageController {


    @GetMapping("/")
        public String redirectTo(){
                return "anime_page.html";
        }


    @PostMapping("/log")
    public String login(){
        return "redirect:/";
    }




}

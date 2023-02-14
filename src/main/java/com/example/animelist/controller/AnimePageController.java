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

import java.util.Enumeration;

@Controller
public class AnimePageController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/anime")
    public String animePage(Model model, HttpServletRequest request) {
        boolean logged = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        System.out.println("logged: " + logged);
        String remUser = request.getRemoteUser();
        System.out.println("user: " + remUser);
        if (remUser != null) {
            UserDetails user = userRepository.findByEmail(remUser).get();
            System.out.println("auth:" + user.getAuthorities());
        }
        System.out.println();
        model.addAttribute("logged",logged);
        model.addAttribute("title", "anime");
        return "anime_page.html";
    }

    @GetMapping("/user/anime")
    public String userPage(Model model) {
        model.addAttribute("title", "user");
        return "anime_page.html";
    }
    @PostMapping("/log")
    public String login(){
        return "redirect:/admin/anime";
    }


    @GetMapping("/admin/anime")
    public String adminPage(Model model) {
        model.addAttribute("title", "admin");
        return "anime_page.html";
    }

}

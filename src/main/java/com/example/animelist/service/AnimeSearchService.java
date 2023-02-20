package com.example.animelist.service;

import com.example.animelist.entity.Anime;
import com.example.animelist.repos.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimeSearchService {
    @Autowired
    private AnimeRepository animeRepository;


    public Page<Anime> findAnimeByName(String name, Pageable pageable) {
        return animeRepository.findByTitleContainingIgnoreCase(name,pageable);
    }
}

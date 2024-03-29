package com.example.animelist.service;

import com.example.animelist.entity.Anime;
import com.example.animelist.entity.Episode;
import com.example.animelist.entity.SavedList;
import com.example.animelist.repos.AnimeRepository;
import com.example.animelist.repos.EpisodeRepository;
import com.example.animelist.repos.SavedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeSearchService {
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private SavedListRepository savedListRepository;
    @Autowired
    private EpisodeRepository episodeRepository;

    public Page<Anime> findAnimeByName(String name, Pageable pageable) {
        return animeRepository.findByTitleContainingIgnoreCase(name, pageable);
    }

    public Optional<SavedList> findSavedListByName(String name) {
        return savedListRepository.findByName(name);
    }

    public Optional<Anime> findByName(String name) {
        return animeRepository.findAnimeByTitle(name);
    }

    public List<Episode> findAnimeEpisodes(Anime anime) {
        return episodeRepository.findAllByAnime(anime);
    }
    public Optional<Anime> findAnimeById(Long id){
        return animeRepository.findById(id);
    }
}

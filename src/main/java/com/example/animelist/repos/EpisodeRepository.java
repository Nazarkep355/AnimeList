package com.example.animelist.repos;

import com.example.animelist.entity.Anime;
import com.example.animelist.entity.Episode;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Long> {

    List<Episode> findAllByAnime(Anime anime);
}

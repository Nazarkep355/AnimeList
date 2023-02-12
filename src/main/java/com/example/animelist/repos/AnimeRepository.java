package com.example.animelist.repos;

import com.example.animelist.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime,Long> {
}

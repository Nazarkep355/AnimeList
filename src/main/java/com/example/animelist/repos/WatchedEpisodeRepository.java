package com.example.animelist.repos;

import com.example.animelist.entity.WatchedEpisode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchedEpisodeRepository extends JpaRepository<WatchedEpisode,Long> {
}

package com.example.animelist.repos;

import com.example.animelist.entity.WatchedEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchedEpisodeRepository extends JpaRepository<WatchedEpisode,Long> {
}

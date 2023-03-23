package com.example.animelist.repos;

import com.example.animelist.entity.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimeRepository extends JpaRepository<Anime,Long> {

//    @Query("select a from Anime a where upper(a.title) like upper(?1)")
@Query("select a from Anime a where upper(a.title) like upper(concat('%', ?1, '%'))")
Page<Anime> findByTitleContainingIgnoreCase(String name,Pageable pageable);

    @Query("select a from Anime a where a.title = ?1")
    Optional<Anime> findAnimeByTitle(String name);
}


package com.example.animelist.repos;

import com.example.animelist.entity.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimeRepository extends JpaRepository<Anime,Long> {

//    @Query("select a from Anime a where upper(a.title) like upper(?1)")
@Query("select a from Anime a where upper(a.title) like upper(concat('%', ?1, '%'))")
Page<Anime> findByTitleContainingIgnoreCase(String name,Pageable pageable);
}

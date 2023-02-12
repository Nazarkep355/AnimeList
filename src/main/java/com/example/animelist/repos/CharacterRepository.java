package com.example.animelist.repos;

import com.example.animelist.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character,Long> {
}

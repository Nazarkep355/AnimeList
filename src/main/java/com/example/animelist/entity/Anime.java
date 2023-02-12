package com.example.animelist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="anime")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    private int episodesNumber;
    @ManyToMany
    private List<Genre> genres;
    @ManyToMany
    private List<Character> characters;
}

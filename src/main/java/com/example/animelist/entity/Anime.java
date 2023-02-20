package com.example.animelist.entity;

import com.example.animelist.service.UserRateService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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
    @OneToMany(mappedBy = "anime")
    private List<Character> characters;
    private String poster;
    @ElementCollection
    private List<String> images;

}

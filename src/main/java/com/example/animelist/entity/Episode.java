package com.example.animelist.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "episodes")
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Anime anime;
    @Column
    private int episodeNum;
    private String fileName;
}

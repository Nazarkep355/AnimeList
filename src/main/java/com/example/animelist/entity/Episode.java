package com.example.animelist.entity;

import com.example.animelist.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "episodes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Anime anime;
    @ManyToOne
    private User user;
    private int episodeNumber;
    private int pauseTime;
}

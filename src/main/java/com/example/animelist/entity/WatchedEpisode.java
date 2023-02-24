package com.example.animelist.entity;

import com.example.animelist.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "watched_episodes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WatchedEpisode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Episode episode;
    @ManyToOne
    private User user;
    private int pauseTime;
}

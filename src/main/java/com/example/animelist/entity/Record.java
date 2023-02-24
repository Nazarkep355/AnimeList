package com.example.animelist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name="records")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    @OneToOne
    private Episode episode;
}

package com.example.jpaproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "artist")
    List<PerformanceArtist> performanceArtists = new ArrayList<>();
//    @ManyToMany(mappedBy = "artists")
//    List<Performance> performances = new ArrayList<>();

    public Artist(String name) {
        this.name = name;
    }
}

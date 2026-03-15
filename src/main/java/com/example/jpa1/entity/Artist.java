package com.example.jpa1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "artist")
    private List<PerformanceArtist> performances = new ArrayList<>();
//    @ManyToMany(mappedBy = "artists")
//    private List<Performance> performances = new ArrayList<>();

    public Artist(String name) {
        this.name = name;
    }
}
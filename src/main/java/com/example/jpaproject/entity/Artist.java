package com.example.jpaproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Artist {

    private Long id;

    private String name;

    public Artist(String name) {
        this.name = name;
    }
}

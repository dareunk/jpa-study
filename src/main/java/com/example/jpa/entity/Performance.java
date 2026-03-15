package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "performance")
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "performance")
    private List<PerformanceArtists> performanceArtists = new ArrayList<>();
}

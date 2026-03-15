package com.example.jpa1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PerformanceArtist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Performance performance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;

    private Integer stageOrder;

    public PerformanceArtist(Performance performance, Artist artist, Integer stageOrder) {
        this.performance = performance;
        this.artist = artist;
        this.stageOrder = stageOrder;
    }

    public boolean isMainPerformer() {
        return stageOrder != null && stageOrder <= 2;
    }

}

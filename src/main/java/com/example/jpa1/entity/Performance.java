package com.example.jpa1.entity;

import com.example.jpa1.embedded.PerformanceInfo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PerformanceInfo performanceInfo;

    @OneToMany(mappedBy = "performance")
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "performance",
            cascade = CascadeType.ALL)
    private List<PerformanceArtist> artists = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(
//            name = "performance_artist",
//            joinColumns = @JoinColumn(name = "performance_id"),
//            inverseJoinColumns = @JoinColumn(name = "artist_id")
//    )
//    private List<Artist> artists = new ArrayList<>();

    public Performance(PerformanceInfo performanceInfo) {
        this.performanceInfo = performanceInfo;
    }

}
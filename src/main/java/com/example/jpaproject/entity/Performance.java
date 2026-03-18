package com.example.jpaproject.entity;

import com.example.jpaproject.embedded.Address;
import com.example.jpaproject.embedded.PerformanceInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "performance")
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "performance")
    private List<PerformanceArtist> performanceArtists = new ArrayList<>();
//    @ManyToMany(mappedBy = "performances")
//            @JoinTable(name = "artist_performance",
//                    joinColumns = @JoinColumn(name = "performance_id"),
//                    inverseJoinColumns = @JoinColumn(name = "artist_id"))
//    List<Artist> artists = new ArrayList<>();

    @Embedded
    private PerformanceInfo performanceInfo;

    @Embedded
    private Address address;

    public Performance(PerformanceInfo performanceInfo) {
        this.performanceInfo = performanceInfo;
    }
    public Performance(PerformanceInfo performanceInfo, Address address) {
        this.performanceInfo = performanceInfo;
        this.address = address;
    }

}

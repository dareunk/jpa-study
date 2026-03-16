package com.example.jpa1.repository;

import com.example.jpa1.entity.Performance;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    @Query("""
            SELECT DISTINCT p
            FROM Performance p
            JOIN FETCH p.artists pa
            JOIN FETCH pa.artist
            """)
    List<Performance> findAllWithArtists();

    @EntityGraph(attributePaths = {
            "artists",
            "artists.artist"
    })
    List<Performance> findAll();
}

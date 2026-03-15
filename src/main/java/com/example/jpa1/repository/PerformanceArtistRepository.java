package com.example.jpa1.repository;

import com.example.jpa1.entity.Artist;
import com.example.jpa1.entity.Performance;
import com.example.jpa1.entity.PerformanceArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerformanceArtistRepository extends JpaRepository <PerformanceArtist, Long>{

    @Query("SELECT pa FROM PerformanceArtist pa WHERE pa.artist = :artist AND pa.stageOrder <= 2")
    List<PerformanceArtist> findMainPerformancesByArtist(Artist artist);

    @Query("SELECT pa FROM PerformanceArtist pa WHERE pa.performance = :performance ORDER BY pa.stageOrder")
    List<PerformanceArtist> findArtistsByStageOrder(Performance performance);

}

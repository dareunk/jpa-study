package com.example.jpa.repository;

import com.example.jpa.entity.PerformanceArtists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceArtistsRepository extends JpaRepository<PerformanceArtists, Long> {
}

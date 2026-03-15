package com.example.jpa1.repository;

import com.example.jpa1.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}

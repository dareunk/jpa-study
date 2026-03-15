package com.example.jpa1.repository;

import com.example.jpa1.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository <Seat, Long>{
}

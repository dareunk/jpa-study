package com.example.jpaproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Seat {

    private Long id;

    private String seatNumber;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}

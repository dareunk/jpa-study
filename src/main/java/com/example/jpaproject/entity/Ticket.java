package com.example.jpaproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Ticket {

    private Long id;

    private LocalDateTime bookingTime;

    private LocalDateTime lastModified;

}

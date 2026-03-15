package com.example.jpa1.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class PerformanceInfo {
    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private LocalDateTime performanceDate;

    private String venue;
    private String description;
    private Integer duration;

    public PerformanceInfo(String title, LocalDateTime performanceDate) {
        this.title = title;
        this.performanceDate = performanceDate;
    }

    public PerformanceInfo(String title, LocalDateTime performanceDate, String venue, String description, Integer duration) {
        this.title = title;
        this.performanceDate = performanceDate;
        this.venue = venue;
        this.description = description;
        this.duration = duration;
    }

    public boolean isUpcoming() {
        return performanceDate.isAfter(LocalDateTime.now());
    }
}

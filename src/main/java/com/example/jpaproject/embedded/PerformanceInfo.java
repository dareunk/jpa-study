package com.example.jpaproject.embedded;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PerformanceInfo {

    private String title;

    private LocalDateTime performanceDate;

    private String venue;
    private String description;
    private Integer duration;

    public PerformanceInfo(String title, LocalDateTime performanceDate, String venue, String description, Integer duration) {
        this.title = title;
        this.performanceDate = performanceDate;
        this.venue = venue;
        this.description = description;
        this.duration = duration;
    }

}

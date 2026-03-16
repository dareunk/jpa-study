package com.example.jpaproject.entity;

import com.example.jpaproject.embedded.Address;
import com.example.jpaproject.embedded.PerformanceInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Performance {

    private Long id;

    private PerformanceInfo performanceInfo;

    private Address address;

    public Performance(PerformanceInfo performanceInfo) {
        this.performanceInfo = performanceInfo;
    }
    public Performance(PerformanceInfo performanceInfo, Address address) {
        this.performanceInfo = performanceInfo;
        this.address = address;
    }

}

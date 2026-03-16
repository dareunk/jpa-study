package com.example.jpa1;

import com.example.jpa1.embedded.Address;
import com.example.jpa1.embedded.PerformanceInfo;
import com.example.jpa1.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

abstract class BaseDataModel {
    static List<User> getUsers() {
        Address address1 = new Address("city1", "street1", "12345");
        Address address2 = new Address("city2", "street2", "11232");
        Address address3 = new Address("city3", "street3", "11236");

        return List.of(
                new User("eunjin", "eunjin@naver.com", address1),
                new User("minah", "minah@naver.com", address2),
                new User("euna", "euna@naver.com", address3)
        );
    }

    static List<Artist> getArtists() {
        return List.of(
                new Artist("bts"),
                new Artist("blackPink"),
                new Artist("newJeans")
        );
    }

    static List<Performance> getPerformances() {
        PerformanceInfo performanceInfo1 = new PerformanceInfo("title1", LocalDateTime.now(), "tera1", "description1", 120);
        PerformanceInfo performanceInfo2 = new PerformanceInfo("title2", LocalDateTime.now(), "tera2", "description2", 130);
        PerformanceInfo performanceInfo3 = new PerformanceInfo("title3", LocalDateTime.now(), "tera3", "description3", 140);
        return List.of(
                new Performance(performanceInfo1),
                new Performance(performanceInfo2),
                new Performance(performanceInfo3)

        );
    }

    static List<Seat> getSeats() {
        return List.of(
                new Seat("1"),
                new Seat("2"),
                new Seat("3"),
                new Seat("4"),
                new Seat("5")
        );
    }

}

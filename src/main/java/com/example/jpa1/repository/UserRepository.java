package com.example.jpa1.repository;

import com.example.jpa1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    Optional<User> findByEmail(String email);

    List<User> findByNameContaining(String keyword);

    @Query("SELECT DISTINCT u FROM User u JOIN u.tickets")
    List<User> findUsersWithTickets();

    @Query("SELECT DISTINCT u FROM User u JOIN u.tickets t WHERE t.performance.id = :performanceId")
    List<User> findUsersByPerformanceId(@Param("performanceId") Long performanceId);

    @Query("SELECT u FROM User u WHERE SIZE(u.tickets) >= :minCount")
    List<User> findUsersWithMinimumTickets(@Param("minCount") int minCount);

}

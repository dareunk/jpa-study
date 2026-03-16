package com.example.jpa1.repository;

import com.example.jpa1.entity.Ticket;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("""
            SELECT t
            FROM Ticket t
            JOIN FETCH t.user
            """)
    List<Ticket> findAllWithUser();

    @Query("""
            SELECT t
            FROM Ticket t
            JOIN FETCH t.user
            JOIN FETCH t.performance
            """)
    List<Ticket> findAllFetchJoin();

    @EntityGraph(attributePaths = {
            "user",
            "performance"
    })
    List<Ticket> findAll();

    List<Ticket> findByUserId(Long userId);

    List<Ticket> findByUserName(String userName);

    List<Ticket> findByPerformanceId(Long performanceId);

    List<Ticket> findByUserIdAndPerformanceId(Long userId, Long performanceId);

    List<Ticket> findByUserIdOrPerformanceId(Long userId, Long performanceId);

    List<Ticket> findByBookingTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Ticket> findByBookingTimeAfter(LocalDateTime date);

    List<Ticket> findByBookingTimeBefore(LocalDateTime date);

    List<Ticket> findByUserNameContaining(String keyword);

    List<Ticket> findByUserNameStartingWith(String prefix);

    List<Ticket> findByUserNameIgnoreCase(String name);

    List<Ticket> findByUserIdOrderByBookingTimeDesc(Long userId);

    List<Ticket> findAllByOrderByBookingTimeAsc();

    boolean existsByUserIdAndPerformanceId(Long userId, Long performanceId);

    long countByUserId(Long userId);

    long countByPerformanceId(Long performanceId);

    void deleteByUserId(Long userId);

    Optional<Ticket> findFirstByUserIdOrderByBookingTimeDesc(Long userId);

    List<Ticket> findTop5ByUserIdOrderByBookingTimeDesc(Long userId);

}

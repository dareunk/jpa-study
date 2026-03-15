package com.example.jpa1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime bookingTime;

    @UpdateTimestamp
    private LocalDateTime lastModified;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    public Ticket(Performance performance, Seat seat) {
        this.performance = performance;
        this.seat = seat;
    }

    public void changeSeat(Seat seat) {
        this.seat = seat;
    }

}

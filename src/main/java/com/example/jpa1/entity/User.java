package com.example.jpa1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="user_name", length=50, nullable=false)
    private String name;

    private String email;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setUser(this);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        ticket.setUser(null);
    }
}
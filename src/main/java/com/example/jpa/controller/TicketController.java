package com.example.jpa.controller;

import com.example.jpa.entity.Ticket;
import com.example.jpa.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public void save(@RequestBody Ticket ticket) {
        ticketService.save(ticket);
    }

}

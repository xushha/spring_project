package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/user/{userId}")
    public List<Ticket> getTicketsByUserId(@PathVariable String userId) {
        return ticketService.getTicketsByUserId(userId);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }
}
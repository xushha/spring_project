package com.example.demo.controller;

import com.example.demo.model.Flight;
import com.example.demo.service.FlightService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/number/{flightNumber}")
    public List<Flight> getFlightsByNumber(@PathVariable String flightNumber) {
        return flightService.getFlightsByNumber(flightNumber);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }
}
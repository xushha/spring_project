package com.example.demo.controller;

import com.example.demo.model.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {


    public static List<Flight> flights = new ArrayList<>();

    static {
        flights.add(new Flight(
                1L,
                "Kyiv",
                "Lviv",
                LocalDateTime.of(2025, 1, 15, 10, 30),
                LocalDateTime.of(2025, 1, 15, 12, 00),
                1500.0,
                "PS101",
                LocalDateTime.now()
        ));
        flights.add(new Flight(
                2L,
                "Odessa",
                "Warsaw",
                LocalDateTime.of(2025, 1, 20, 14, 20),
                LocalDateTime.of(2025, 1, 20, 16, 30),
                2300.0,
                "PS202",
                LocalDateTime.now()
        ));
    }


    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flights);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        return flights.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        flight.setId(generateNewId());
        flight.setCreationDate(LocalDateTime.now());
        flights.add(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flights.removeIf(f -> f.getId().equals(id));
        return ResponseEntity.noContent().build();
    }


    private Long generateNewId() {
        return flights.stream()
                .mapToLong(Flight::getId)
                .max()
                .orElse(0L) + 1;
    }
}

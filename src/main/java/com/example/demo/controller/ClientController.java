package com.example.demo.controller;
import com.example.demo.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {


    public static List<Client> clients = new ArrayList<>();

    static {
        clients.add(new Client(
                1,
                "Taras",
                "Filipenko",
                "taras123@gmail.com",
                LocalDateTime.of(2025, 1, 15, 12, 00)
        ));
        clients.add(new Client(
                2,
                "Olena",
                "Ivanenko",
                "olena5634@gmail.com",
                LocalDateTime.of(2025, 1, 15, 12, 00)
        ));
    }


    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clients);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
        return clients.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}

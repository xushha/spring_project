package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.CityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }
}
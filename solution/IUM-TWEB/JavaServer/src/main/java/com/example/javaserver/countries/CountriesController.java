package com.example.javaserver.countries;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountriesController {
    private final CountriesService countriesService;

    @Autowired
    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping
    public List<Countries> getAllCountries() {
        return countriesService.getAllCountries();
    }
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Countries>> getCountriesByMovieRating(@PathVariable Double rating) {
        List<Countries> countries = countriesService.getCountriesByMovieRating(rating);
        return ResponseEntity.ok(countries);
    }
}

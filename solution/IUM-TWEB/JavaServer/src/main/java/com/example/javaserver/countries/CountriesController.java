package com.example.javaserver.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Countries>> getAllCountries() {
        List<Countries> countries = countriesService.getAllCountries();

        if (countries == null || countries.isEmpty()) {
            // Restituisce 404 (Not Found) se la lista è vuota o null
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce 200 (OK) con la lista dei paesi
        return ResponseEntity.ok(countries);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<String>> getCountriesByName(@PathVariable String name) {
        List<String> countries = countriesService.getCountriesByCountryByName(name);

        if (countries == null || countries.isEmpty()) {
            // Restituisce 404 (Not Found) se non ci sono risultati
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce 200 (OK) con la lista dei paesi trovati
        return ResponseEntity.ok(countries);
    }

    @GetMapping("FilmsByCountry")
    public ResponseEntity<List<Object[]>> getFilmsByCountry() {
        List<Object[]> films = countriesService.getFindNumFilmsByCountry();

        if (films == null || films.isEmpty()) {
            // Restituisce 404 (Not Found) se non ci sono risultati
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce 200 (OK) con la lista dei film per paese
        return ResponseEntity.ok(films);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<List<Countries>> getCountriesById(@PathVariable Long id) {
        List<Countries> countries = countriesService.getFindCountriesByCountryId(id);

        if (countries == null || countries.isEmpty()) {
            // Restituisce 404 (Not Found) se non ci sono risultati
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce 200 (OK) con i paesi trovati
        return ResponseEntity.ok(countries);
    }
}

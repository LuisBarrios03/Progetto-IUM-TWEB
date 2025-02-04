package com.example.javaserver.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * REST controller for managing countries.
 */
@RestController
@RequestMapping("countries")
public class CountriesController {
    private final CountriesService countriesService;

    /**
     * Constructs a CountriesController with the specified CountriesService.
     *
     * @param countriesService the service for managing countries
     */
    @Autowired
    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    /**
     * Retrieves countries by the specified ID.
     *
     * @param id the ID of the country
     * @return a ResponseEntity containing the list of countries
     */
    @GetMapping("id/{id}")
    public ResponseEntity<List<Map<String, Object>>> getCountriesById(@PathVariable Long id) {
        List<Map<String, Object>> countries = countriesService.getFindCountriesByCountryId(id);

        if (countries == null || countries.isEmpty()) {
            // Returns 404 (Not Found) if no countries are found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Returns 200 (OK) with the list of countries
        return ResponseEntity.ok(countries);
    }
}
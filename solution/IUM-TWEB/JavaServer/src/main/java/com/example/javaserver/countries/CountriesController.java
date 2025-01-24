package com.example.javaserver.countries;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @GetMapping("name/{name}")
    public List<String> getCountriesByName(@PathVariable String name) {
        return countriesService.getCountriesByCountryByName(name);
    }

    @GetMapping("FilmsByCountry")
    public List<Object[]> getFilmsByCountry(){
        return countriesService.getFindNumFilmsByCountry();
    }

}

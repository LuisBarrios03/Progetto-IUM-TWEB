package com.example.javaserver.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesService {
    private final CountriesRepository countriesRepository;

    @Autowired
    public CountriesService(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    public List<Countries>getAllCountries(){
        return countriesRepository.findAll();
    }

    public List<Countries>getCountriesByMovieRating(Double rating){
        return countriesRepository.findByMovieRatingGreaterThan(rating);
    }
}

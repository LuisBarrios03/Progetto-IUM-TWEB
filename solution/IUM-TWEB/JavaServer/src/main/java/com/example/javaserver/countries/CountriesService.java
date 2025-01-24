package com.example.javaserver.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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

    public List<String> getCountriesByCountryByName(String country){
        return countriesRepository.findCountriesByMovieByName(country);
    }

    public List<Object[]> getFindNumFilmsByCountry(){
        return countriesRepository.findNumFilmsByCountry();
    }


}

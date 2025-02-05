package com.example.javaserver.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for managing countries.
 */
@Service
public class CountriesService {
    private final CountriesRepository countriesRepository;

    /**
     * Constructs a CountriesService with the specified CountriesRepository.
     *
     * @param countriesRepository the repository for countries
     */
    @Autowired
    public CountriesService(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    /**
     * Retrieves countries by the specified country ID.
     *
     * @param countryId the ID of the country
     * @return a list of countries associated with the specified country ID
     */
    public List<Map<String, Object>> getFindCountriesByCountryId(Long countryId) {
        List<Object[]> results = countriesRepository.findCountriesByCountryId(countryId);
        List<Map<String, Object>> countries = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> country = new HashMap<>();
            country.put("country", result[0]);
            countries.add(country);
        }
        return countries;
    }
}
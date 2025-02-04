package com.example.javaserver.releases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Releases entities.
 */
@Service
public class ReleasesService {
    private final ReleasesRepository releasesRepository;

    /**
     * Constructor for ReleasesService.
     *
     * @param releasesRepository the repository for Releases entities
     */
    @Autowired
    public ReleasesService(ReleasesRepository releasesRepository) {
        this.releasesRepository = releasesRepository;
    }

    /**
     * Retrieves all releases.
     *
     * @return a list of all releases
     */
    public List<Releases> getAllReleases() {
        return releasesRepository.findAll();
    }

    /**
     * Retrieves releases by country.
     *
     * @param country the country of the releases
     * @return a list of releases for the specified country
     */
    public List<Object[]> getReleasesByCountry(String country) {
        return releasesRepository.findReleasesByCountry(country);
    }

    /**
     * Counts movies by country.
     *
     * @param country the country of the releases
     * @return the number of movies released in the specified country
     */
    public Long getCountMoviesByCountry(String country) {
        return releasesRepository.countMoviesByCountry(country);
    }

    /**
     * Retrieves releases by movie name.
     *
     * @param movieName the name of the movie
     * @return a list of releases for the specified movie name
     */
    public List<Object[]> getReleasesByMovieName(String movieName) {
        return releasesRepository.findReleasesByMovieName(movieName);
    }
}
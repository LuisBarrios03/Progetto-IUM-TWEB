package com.example.javaserver.releases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Releases entities.
 */
@RestController
@RequestMapping("/releases")
public class ReleasesController {
    @Autowired
    private ReleasesService releasesService;

    /**
     * Constructor for ReleasesController.
     *
     * @param releasesService the service for Releases entities
     */
    public ReleasesController(ReleasesService releasesService) {
        this.releasesService = releasesService;
    }

    /**
     * Retrieves all releases.
     *
     * @return a list of all releases
     */
    @GetMapping("/")
    public List<Releases> getAllReleases() {
        return releasesService.getAllReleases();
    }

    /**
     * Retrieves releases by country.
     *
     * @param country the country of the releases
     * @return a list of releases for the specified country
     */
    @GetMapping("/releases-by-country/{country}")
    public ResponseEntity<List<Object[]>> getReleasesByCountry(@PathVariable String country) {
        List<Object[]> releases = releasesService.getReleasesByCountry(country);
        if (releases == null || releases.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(releases);
    }

    /**
     * Counts movies by country.
     *
     * @param country the country of the releases
     * @return the number of movies released in the specified country
     */
    @GetMapping("/count-movies-by-country/{country}")
    public ResponseEntity<Long> countMoviesByCountry(@PathVariable String country)   {
        Long releases = releasesService.getCountMoviesByCountry(country);
        if (releases == null ) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(releases);
    }

    /**
     * Retrieves releases by movie name.
     *
     * @param movieName the name of the movie
     * @return a list of releases for the specified movie name
     */
    @GetMapping("/releases-by-movie/{movieName}")
    public ResponseEntity<List<Object[]>> getReleasesByMovieName(@PathVariable String movieName)  {
        List<Object[]> releases = releasesService.getReleasesByMovieName(movieName);
        if (releases == null || releases.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(releases);
    }
}
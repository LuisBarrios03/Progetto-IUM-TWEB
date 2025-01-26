package com.example.javaserver.releases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Releases")
public class ReleasesController {
    @Autowired
    private ReleasesService releasesService;

    public ReleasesController(ReleasesService releasesService) {
        this.releasesService = releasesService;
    }

    @GetMapping
    public List<Releases> getAllReleases() {
        return releasesService.getAllReleases();
    }

    @GetMapping("/releases-by-country")
    public List<Object[]> getReleasesByCountry(@RequestParam String country) {
        return releasesService.getReleasesByCountry(country);
    }

    @GetMapping("/count-movies-by-country")
    public Long countMoviesByCountry(@RequestParam String country) {
        return releasesService.getCountMoviesByCountry(country);
    }

    @GetMapping("/releases-by-movie")
    public List<Object[]> getReleasesByMovieName(@RequestParam String movieName) {
        return releasesService.getReleasesByMovieName(movieName);
    }

}

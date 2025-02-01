package com.example.javaserver.releases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/releases")
public class ReleasesController {
    @Autowired
    private ReleasesService releasesService;

    public ReleasesController(ReleasesService releasesService) {
        this.releasesService = releasesService;
    }

    @GetMapping("/")
    public List<Releases> getAllReleases() {
        return releasesService.getAllReleases();
    }

    @GetMapping("/releases-by-country/{country}")
    public ResponseEntity<List<Object[]>> getReleasesByCountry(@PathVariable String country) {
        List<Object[]> releases = releasesService.getReleasesByCountry(country);
        if (releases == null || releases.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(releases);
    }

    @GetMapping("/count-movies-by-country/{country}")
    public ResponseEntity<Long> countMoviesByCountry(@PathVariable String country)   {
        Long releases = releasesService.getCountMoviesByCountry(country);
        if (releases == null ) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(releases);
    }

    @GetMapping("/releases-by-movie/{movieName}")
    public ResponseEntity<List<Object[]>> getReleasesByMovieName(@PathVariable String movieName)  {
        List<Object[]> releases = releasesService.getReleasesByMovieName(movieName);
        if (releases == null || releases.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(releases);
    }






}

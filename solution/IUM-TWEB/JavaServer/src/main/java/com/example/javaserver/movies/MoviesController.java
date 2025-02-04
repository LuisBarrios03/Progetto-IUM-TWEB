package com.example.javaserver.movies;

import com.example.javaserver.genres.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * REST controller for managing Movies entities.
 */
@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MoviesService moviesService;

    /**
     * Constructs a MoviesController with the specified MoviesService.
     *
     * @param moviesService the service for managing movies
     */
    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    /**
     * Finds movies by the specified ID.
     *
     * @param id the ID of the movie
     * @return a ResponseEntity containing a list of movies
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<List<Movies>> moviesById(@PathVariable Long id) {
        List<Movies> movie = moviesService.moviesById(id);
        if (movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }

    /**
     * Finds the latest released movies.
     *
     * @return a ResponseEntity containing a list of latest released movies
     */
    @GetMapping("/latest-releases")
    public ResponseEntity<List<Map<String, Object>>> getLatestReleasedMovies() {
        LocalDate today = LocalDate.now();
        final Pageable pageable = PageRequest.of(0, 5);
        List<Map<String, Object>> movie = moviesService.getFindLatestReleasedMovies(today, pageable);
        if (movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }

    /**
     * Finds the top-rated movies.
     *
     * @return a ResponseEntity containing a list of top-rated movies
     */
    @GetMapping("/TopRate")
    public ResponseEntity<List<Map<String, Object>>> getTopRatedMovies() {
        final Pageable pageable = PageRequest.of(0, 15);
        List<Map<String, Object>> movie = moviesService.findTopRatedMovies(pageable);
        if (movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }

    /**
     * Searches for movies based on various criteria.
     *
     * @param title the title of the movie
     * @param genres the genres of the movie
     * @param duration the duration of the movie
     * @param rating the rating of the movie
     * @param year the release year of the movie
     * @param page the page number for pagination
     * @param size the page size for pagination
     * @return a ResponseEntity containing a list of movies matching the criteria
     */
    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> searchMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) List<String> genres,
            @RequestParam(required = false) Integer duration,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false) Integer year,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        List<Map<String, Object>> movie = moviesService.searchMovies(title, genres, duration, rating, year, page, size);
        if (movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }

    /**
     * Finds movies by the specified actor's name.
     *
     * @param actorName the name of the actor
     * @return a ResponseEntity containing a list of movies featuring the actor
     */
    @GetMapping("/name")
    public ResponseEntity<List<Map<String, Object>>> getAllMoviesbyNameActor(@RequestParam String actorName) {
        List<Map<String, Object>> movie = moviesService.searchNameActor(actorName);
        if (movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }

    /**
     * Finds the most recent movies.
     *
     * @return a ResponseEntity containing a list of most recent movies
     */
    @GetMapping("/recent")
    public ResponseEntity<List<Map<String, Object>>> getRecentMovies() {
        final Pageable pageable = PageRequest.of(0, 15);
        List<Map<String, Object>> movie = moviesService.FindMostRecent(pageable);
        if (movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }
}   
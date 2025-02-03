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


@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MoviesService moviesService;
    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }



    @GetMapping("/id/{id}")
    public ResponseEntity <List<Movies>> moviesById(@PathVariable Long id) {
        List<Movies> movie = moviesService.moviesById(id);
        if(movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity <List<Movies>> moviesByDate(@PathVariable int date) {
        List<Movies> movie = moviesService.moviesByDate(date);
        if(movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity <List<Movies>> moviesByRating(@PathVariable Float rating) {
        List<Movies> movie = moviesService.moviesByRating(rating);
        if(movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }



    @GetMapping("/latest-releases")
    public ResponseEntity <List<Map<String, Object>>> getLatestReleasedMovies() {
        LocalDate today = LocalDate.now();
        final Pageable pageable = PageRequest.of(0,5);

        List<Map<String, Object>> movie = moviesService.getFindLatestReleasedMovies(today,pageable);
        if (movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/TopRate")
    public ResponseEntity<List<Map<String, Object>>>getTopRatedMovies() {
        // Paginazione personalizzata
        final Pageable pageable = PageRequest.of(0,15);
        List<Map<String, Object>> movie = moviesService.findTopRatedMovies(pageable);
        if (movie == null || movie.isEmpty()) {
            // Se non ci sono risultati, restituisci un 404 (NOT FOUND)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Se ci sono risultati, restituisci un 200 OK con i dati
        return ResponseEntity.ok(movie);
    }
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
            // Se non ci sono risultati, restituisci un 404 (NOT FOUND)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Se ci sono risultati, restituisci un 200 OK con i dati
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Map<String, Object>>> getAllMoviesbyNameActor(@RequestParam String actorName) {
        List<Map<String, Object>> movie = moviesService.searchNameActor(actorName);
        if (movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
    }
    @GetMapping("/recent")
    public ResponseEntity<List<Map<String, Object>>>getRecentMovies() {
        // Paginazione personalizzata
        final Pageable pageable = PageRequest.of(0,15);
        List<Map<String, Object>> movie = moviesService.FindMostRecent(pageable);
        if (movie == null || movie.isEmpty()) {
            // Se non ci sono risultati, restituisci un 404 (NOT FOUND)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Se ci sono risultati, restituisci un 200 OK con i dati
        return ResponseEntity.ok(movie);
    }
}

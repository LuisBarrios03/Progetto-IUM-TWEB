package com.example.javaserver.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MoviesService moviesService;
    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity <List<Movies>> moviesByName(@PathVariable String name) {
        List<Movies> movie = moviesService.moviesByName(name);
        if(movie == null || movie.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movie);
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
    public ResponseEntity<List<MoviesDTO>> getLatestReleasedMovies() {
        LocalDate today = LocalDate.now();
        final Pageable pageable = PageRequest.of(1,10   );
        List<MoviesDTO> movie = moviesService.getFindLatestReleasedMovies(today,pageable);
        if (movie == null || movie.isEmpty()) {
            // Se non ci sono risultati, restituisci un 404 (NOT FOUND)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Se ci sono risultati, restituisci un 200 OK con i dati
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/TopRate")
    public ResponseEntity<List<Movies>>getTopRatedMovies() {
        // Paginazione personalizzata
        final Pageable pageable = PageRequest.of(1,9);
        List<Movies> movie = moviesService.findTopRatedMovies(pageable);
        if (movie == null || movie.isEmpty()) {
            // Se non ci sono risultati, restituisci un 404 (NOT FOUND)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Se ci sono risultati, restituisci un 200 OK con i dati
        return ResponseEntity.ok(movie);
    }

}

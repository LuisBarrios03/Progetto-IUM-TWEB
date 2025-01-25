package com.example.javaserver.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MoviesService moviesService;
    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/{name}")
    public List<Movies> moviesByName(@RequestParam String name) {
        return moviesService.moviesByName(name);
    }

    @GetMapping("/{id}")
    public String moviesById(@RequestParam Long id) {
            return moviesService.moviesById(id);
    }
    @GetMapping("/{date}")
    public List<Movies> moviesByDate(@RequestParam int date) {
        return moviesService.moviesByDate(date);
    }
    @GetMapping("/{rating}")
    public List<Movies> moviesByRating(@RequestParam Float rating) {
        return moviesService.moviesByRating(rating);
    }

}

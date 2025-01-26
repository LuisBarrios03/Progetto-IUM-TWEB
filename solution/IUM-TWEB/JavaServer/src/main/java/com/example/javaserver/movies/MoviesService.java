package com.example.javaserver.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MoviesService {
    private final MoviesRepository moviesRepository;
    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }
    public List<Movies> moviesByName(String name) {
        return moviesRepository.moviesByName(name);
    }
    public List<Movies> moviesById(Long id) {
        return moviesRepository.movieById(id);
    }
    public List<Movies> moviesByRating(Float rating) {
        return moviesRepository.moviesByRating(rating);
    }
    public List<Movies> moviesByDate(int date) {
        return moviesRepository.moviesByDate(date);
    }
}

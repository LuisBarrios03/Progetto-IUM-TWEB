package com.example.javaserver.movies;
import com.example.javaserver.genres.Genres;
import com.example.javaserver.releases.Releases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


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


    public List<Map<String, Object>> getFindLatestReleasedMovies(LocalDate today , Pageable pageable) {
        List<Object[]> results = moviesRepository.findLatestReleasedMovies(today,pageable);
        List<Map<String, Object>> movies = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> movie = new HashMap<>();
            movie.put("id", result[0]);
            movie.put("name", result[1]);
            movie.put("posters", result[2]);
            movie.put("description", result[3]);
            movies.add(movie);
        }
        System.out.println(movies);
        return movies;
    }



    public List<Map<String, Object>> findTopRatedMovies(Pageable pageable) {
        List<Object[]> results = moviesRepository.findTopRatedMovies(pageable);

        List<Map<String, Object>> movies = new ArrayList<>();
        for (Object[] obj : results) {
            Map<String, Object> movie = new HashMap<>();
            movie.put("id", obj[0]);
            movie.put("name", obj[1]);
            movie.put("description", obj[2]);
            movie.put("date", obj[3]);
            movie.put("rating", obj[4]);
            movie.put("tagline", obj[5]);
            movie.put("minute", obj[6]);
            movie.put("link", obj[7]);
            movies.add(movie);
        }

        return movies;
    }

    public List<Map<String, Object>> searchMovies(String title, List<String> genres, Integer duration, Double rating, Integer year, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Object[]> results = moviesRepository.searchMovies(title, genres, duration, rating, year, pageable);
        List<Map<String, Object>> movies = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> movie = new HashMap<>();
            movie.put("id", result[0]);
            movie.put("name", result[1]);
            movie.put("link", result[2]);
            movie.put("rating", result[3]);
            movies.add(movie);

        }
        System.out.println(movies);
        return movies;
    }
}

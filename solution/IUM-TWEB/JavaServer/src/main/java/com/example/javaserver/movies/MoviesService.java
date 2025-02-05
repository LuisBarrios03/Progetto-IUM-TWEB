package com.example.javaserver.movies;

import com.example.javaserver.genres.Genres;
import com.example.javaserver.releases.Releases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for managing Movies entities.
 */
@Service
public class MoviesService {
    private final MoviesRepository moviesRepository;

    /**
     * Constructs a MoviesService with the specified MoviesRepository.
     *
     * @param moviesRepository the repository for managing movies
     */
    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    /**
     * Finds movies by the specified ID.
     *
     * @param id the ID of the movie
     * @return a list of movies
     */
    public List<Movies> moviesById(Long id) {
        return moviesRepository.movieById(id);
    }

    /**
     * Finds the latest released movies up to the specified date.
     *
     * @param today the current date
     * @param pageable the pagination information
     * @return a list of latest released movies
     */
    public List<Map<String, Object>> getFindLatestReleasedMovies(LocalDate today, Pageable pageable) {
        List<Object[]> results = moviesRepository.findLatestReleasedMovies(today, pageable);
        List<Map<String, Object>> movies = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> movie = new HashMap<>();
            movie.put("id", result[0]);
            movie.put("name", result[1]);
            movie.put("posters", result[2]);
            movie.put("description", result[3]);
            movies.add(movie);
        }
        return movies;
    }

    /**
     * Finds the top-rated movies for the year 2024 with a rating of 5 or less.
     *
     * @param pageable the pagination information
     * @return a list of top-rated movies
     */
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
     * @return a list of movies matching the criteria
     */
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
        return movies;
    }

    /**
     * Finds movies by the specified actor's name.
     *
     * @param actorName the name of the actor
     * @return a list of movies featuring the actor
     */
    public List<Map<String, Object>> searchNameActor(String actorName) {
        List<Object[]> results = moviesRepository.findMoviesByActorName(actorName);
        List<Map<String, Object>> movies = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> movie = new HashMap<>();
            movie.put("id", result[0]);
            movie.put("rating", result[1]);
            movie.put("role", result[2]);
            movie.put("name", result[3]);
            movie.put("link", result[4]);
            movies.add(movie);
        }
        return movies;
    }

    /**
     * Finds the most recent movies for the year 2024 with a rating of 5 or less.
     *
     * @param pageable the pagination information
     * @return a list of most recent movies
     */
    public List<Map<String, Object>> FindMostRecent(Pageable pageable) {
        List<Object[]> results = moviesRepository.findMostRecent(pageable);
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
}
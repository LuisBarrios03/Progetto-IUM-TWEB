package com.example.javaserver.movies;
import com.example.javaserver.releases.Releases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
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


    public List<MoviesDTO> getFindLatestReleasedMovies(LocalDate today , Pageable pageable) {
        List<Movies> movies = moviesRepository.findLatestReleasedMovies(today, pageable);  // Recupera i film più recenti dalla repository
        return movies.stream().map(movie -> {
            // Ottieni l'ultimo rilascio (se esiste)
            Releases latestRelease = movie.getRelease().stream()
                    .filter(release -> !release.getReleaseDate().toLocalDate().isAfter(today)) // Filtra i rilasci che sono passati
                    .max(Comparator.comparing(Releases::getReleaseDate)) // Ordina per data di rilascio decrescente
                    .orElse(null); // Se non ci sono rilasci, torna null

            return new MoviesDTO(
                    movie.getId(),
                    movie.getName(),
                    movie.getTagline(),
                    movie.getDescription(),
                    movie.getMinute(),
                    movie.getRating() != null ? movie.getRating() : 0.0,  // Se rating è null, imposta 0.0
                    movie.getPosters() != null ? movie.getPosters().getLink() : "https://a.ltrbxd.com/resized/film-poster/6/4/1/9/6/1/641961-bullet-train-0-230-0-345-crop.jpg?v=9245faa1ba",
                    latestRelease != null ? latestRelease.getReleaseDate() : null // Assegna la data dell'ultimo rilascio, se presente
            );
        }).collect(Collectors.toList());
    }



    public List<Movies> findTopRatedMovies(Pageable pageable) {
        return moviesRepository.findTopRatedMovies(pageable);
    }
}

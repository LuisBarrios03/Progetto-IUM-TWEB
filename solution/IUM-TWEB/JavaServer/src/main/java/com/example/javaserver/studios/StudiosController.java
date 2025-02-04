package com.example.javaserver.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Studios entities.
 */
@RestController
@RequestMapping("/api/studios")
public class StudiosController {
    @Autowired
    private StudiosService studiosService;

    /**
     * Constructor for StudiosController.
     *
     * @param studiosService the service for Studios entities
     */
    public StudiosController(StudiosService studiosService) {
        this.studiosService = studiosService;
    }

    /**
     * Retrieves all studios.
     *
     * @return a list of all studios
     */
    @GetMapping("/")
    public List<Studios> getAllStudios() {
        return studiosService.getAllStudios();
    }

    /**
     * Retrieves studios by movie name.
     *
     * @param movieName the name of the movie
     * @return a list of studios for the specified movie name
     */
    @GetMapping("/studio-by-movie/{movieName}")
    public ResponseEntity<List<Object[]>> getStudioByMovie(@PathVariable String movieName) {
        List<Object[]> studios = studiosService.getStudiosByStudioByName(movieName);
        if (studios == null || studios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(studios);
    }

    /**
     * Counts the number of films produced by each studio.
     *
     * @param studioName the name of the studio
     * @return the number of films produced by the specified studio
     */
    @GetMapping("/num-films-by-studio/{studioName}")
    public ResponseEntity<List<Object[]>> getNumFilmsByStudio(@PathVariable String studioName) {
        List<Object[]> studios = studiosService.getFindNumFilmsByStudio(studioName);
        if (studios == null || studios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(studios);
    }

    /**
     * Retrieves movies by studio name.
     *
     * @param studioName the name of the studio
     * @return a list of movies for the specified studio name
     */
    @GetMapping("/movies-by-studio/{studioName}")
    public ResponseEntity<List<Object[]>> getMoviesByStudio(@PathVariable String studioName) {
        List<Object[]> studios = studiosService.getMoviesByStudio(studioName);
        if (studios == null || studios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(studios);
    }

    /**
     * Retrieves all studios with their respective movies.
     *
     * @return a list of all studios with their respective movies
     */
    @GetMapping("/studios-with-movies")
    public ResponseEntity<List<Object[]>> getStudiosWithMovies() {
        List<Object[]> studios = studiosService.getStudiosWithMovies();
        if (studios == null || studios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(studios);
    }
}
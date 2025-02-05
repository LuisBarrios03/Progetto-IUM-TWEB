package com.example.javaserver.genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * REST controller for managing genres.
 */
@Controller
@RequestMapping("genres")
public class GenresController {

    private final GenresService genresService;

    /**
     * Constructs a GenresController with the specified GenresService.
     *
     * @param genresService the service for managing genres
     */
    @Autowired
    public GenresController(GenresService genresService) {
        this.genresService = genresService;
    }

    /**
     * Retrieves all genres.
     *
     * @return a ResponseEntity containing the list of genres
     */
    @GetMapping("getAllGenres")
    public ResponseEntity<List<Map<String, Object>>> GetAllGenres(){
        List<Map<String, Object>> genres = genresService.getAllGenre();
        if (genres == null || genres.isEmpty()) {
            // Returns 404 (Not Found) if no genres are found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Returns 200 (OK) with the list of genres
        return ResponseEntity.ok(genres);
    }
}
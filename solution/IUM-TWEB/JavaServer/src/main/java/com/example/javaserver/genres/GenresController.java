package com.example.javaserver.genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("genres")
public class GenresController {

    private final GenresService genresService;

    @Autowired
    public GenresController(GenresService genresService) {
        this.genresService = genresService;
    }

    @GetMapping
    public ResponseEntity<List<Genres>>getAllGenres() {
        List<Genres> genres = genresService.getAllGenres();

        if (genres == null || genres.isEmpty()) {
            // Restituisce una risposta con status 404 (Not Found) se la lista è vuota
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce la lista con status 200 (OK)
        return ResponseEntity.ok(genres);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<List<Genres>> getGenreById(@PathVariable Long id) {

        List<Genres> genres = genresService.getGenreById(id);

        if (genres == null || genres.isEmpty()) {
            // Restituisce una risposta con status 404 (Not Found) se non ci sono generi
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce i generi con status 200 (OK)
        return ResponseEntity.ok(genres);
        //return genresService.getGenreById(id);
    }

    @GetMapping("getAllGenres")
    public ResponseEntity<List<Map<String, Object>>> GetAllGenres(){
        List<Map<String, Object>> genres = genresService.getAllGenre();
        if (genres == null || genres.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(genres);
    }
}

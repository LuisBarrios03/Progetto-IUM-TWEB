package com.example.javaserver.actors;

import com.example.javaserver.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actors")
public class ActorsController {
    private final ActorsService actorsService;

    @Autowired
    public ActorsController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @GetMapping
    public ResponseEntity<List<Actors>> getAllActors() {
        List<Actors> actors = actorsService.findAllActors();

        if (actors == null || actors.isEmpty()) {
            // Restituisce 404 (Not Found) se non ci sono attori
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce 200 (OK) con la lista degli attori
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/by-movie-name/{movieName}")
    public ResponseEntity<List<Actors>> getActorsByMovieName(@PathVariable String movieName) {
        List<Actors> actors = actorsService.findActorsByMovieName(movieName);

        if (actors == null || actors.isEmpty()) {
            // Restituisce 404 (Not Found) se non ci sono attori per quel film
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce 200 (OK) con la lista degli attori
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/by-actor-name/{actorName}")
    public ResponseEntity<List<Movies>> getMoviesByActorName(@PathVariable String actorName) {
        List<Movies> movies = actorsService.findMoviesByActorName(actorName);

        if (movies == null || movies.isEmpty()) {
            // Restituisce 404 (Not Found) se non ci sono film per quell'attore
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce 200 (OK) con la lista dei film
        return ResponseEntity.ok(movies);
    }
}

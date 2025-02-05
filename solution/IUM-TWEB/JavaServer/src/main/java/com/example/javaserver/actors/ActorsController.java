package com.example.javaserver.actors;

import com.example.javaserver.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing actors.
 */
@RestController
@RequestMapping("actors")
public class ActorsController {
    private final ActorsService actorsService;

    /**
     * Constructs an ActorsController with the specified ActorsService.
     *
     * @param actorsService the service for managing actors
     */
    @Autowired
    public ActorsController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    /**
     * Retrieves movies by the specified actor name.
     *
     * @param actorName the name of the actor
     * @return a ResponseEntity containing the list of movies featuring the specified actor
     */
    @GetMapping("/by-actor-name/{actorName}")
    public ResponseEntity<List<Movies>> getMoviesByActorName(@PathVariable String actorName) {
        List<Movies> movies = actorsService.findMoviesByActorName(actorName);

        if (movies == null || movies.isEmpty()) {
            // Returns 404 (Not Found) if no movies are found for the specified actor
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Returns 200 (OK) with the list of movies
        return ResponseEntity.ok(movies);
    }
}
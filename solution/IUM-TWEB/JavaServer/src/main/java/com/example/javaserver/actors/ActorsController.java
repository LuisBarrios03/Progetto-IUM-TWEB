package com.example.javaserver.actors;

import com.example.javaserver.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorsController {
    //define the object service
    private final ActorsService actorsService;

    // define an Autowired service in the constructor
    @Autowired
    public ActorsController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @GetMapping
    public List<Actors>getAllActors() {
        return actorsService.findAllActors();
    }


    @GetMapping("/by-movie-name/{movieName}")
    public List<Actors> getActorsByMovieName(@PathVariable String movieName) {
        return actorsService.findActorsByMovieName(movieName);
    }

    @GetMapping("/by-actor-name/{actorName}")
    public ResponseEntity<List<Movies>> getMoviesByActorName(@PathVariable String actorName) {
        List<Movies> movies = actorsService.findMoviesByActorName(actorName);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}


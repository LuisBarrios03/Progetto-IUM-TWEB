package com.example.javaserver.actors;

import com.example.javaserver.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService {
    //define object repository
    private final ActorsRepository actorsRepository;

    @Autowired
    public ActorsService(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }
    public List<Actors> findAllActors() {
        return actorsRepository.findAll();
    }

    public List<Actors>findActorsByMovieName(String movieName) {
        return actorsRepository.findActorsByMovie(movieName);
    }

    public List<Movies>findMoviesByActorName(String actorName) {
        return actorsRepository.findMoviesByActorName(actorName);
    }
}

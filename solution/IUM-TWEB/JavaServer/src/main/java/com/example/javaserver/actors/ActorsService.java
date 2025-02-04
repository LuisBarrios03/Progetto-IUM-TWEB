package com.example.javaserver.actors;

import com.example.javaserver.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing actors.
 */
@Service
public class ActorsService {
    //define object repository
    private final ActorsRepository actorsRepository;

    /**
     * Constructs an ActorsService with the specified ActorsRepository.
     *
     * @param actorsRepository the repository for actors
     */
    @Autowired
    public ActorsService(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }


    /**
     * Retrieves movies by the specified actor name.
     *
     * @param actorName the name of the actor
     * @return a list of movies featuring the specified actor
     */
    public List<Movies> findMoviesByActorName(String actorName) {
        return actorsRepository.findMoviesByActorName(actorName);
    }
}
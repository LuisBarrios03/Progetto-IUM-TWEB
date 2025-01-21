package com.example.javaserver.actors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorsService {
    private final ActorsRepository actorsRepository;

    @Autowired
    public ActorsService(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    public Actors saveActors(Actors actors) {
        return actorsRepository.save(actors);
    }
}

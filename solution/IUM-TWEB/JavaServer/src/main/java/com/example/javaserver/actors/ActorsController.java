package com.example.javaserver.actors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ActorsController {

    private final ActorsService actorsService;
    // define an Autowired service in the constructor
    @Autowired
    public ActorsController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @GetMapping("/{indentity}")
    public Actors getActors(@PathVariable Long identity) {
        return ActorsRepository.findByIdentity(identity);
    }


}
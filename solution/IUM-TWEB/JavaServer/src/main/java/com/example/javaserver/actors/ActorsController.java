package com.example.javaserver.actors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorsController {
    private final ActorsService actorsService;
    // define an Autowired service in the constructor
    @Autowired
    public ActorsController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

   /* @GetMapping("/{indentity}")
    public Actors getActors(@PathVariable Long identity) {
        return ActorsRepository.findByIdentity(identity);
    }
*/
}


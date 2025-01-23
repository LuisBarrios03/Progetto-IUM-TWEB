package com.example.javaserver.actors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/actors")
public class ActorsController {
    //define the object service
    private final ActorsService actorsService;

    // define an Autowired service in the constructor
    @Autowired
    public ActorsController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @GetMapping
    public List<Actors> getAllActors() {
        return actorsService.getAllActors();
    }

    //create destination /role
    /*@GetMapping("/role")
    public List<Actors> getActorsByRole(@RequestParam String role){
            return actorsService.getActorsByRole(role);
    }*/
    @GetMapping("/role")
    public String getActorsByRole(@RequestParam String role,Model model) {
        // Aggiunge gli attori filtrati per ruolo al modello
        model.addAttribute("actors", actorsService.getActorsByRole(role));
        return "actors"; // Restituisce la vista HTML "actors"
    }
    //create destination by name
    @GetMapping("/name")

    public List<Actors> getActorsByName(@RequestParam String name){
        return actorsService.getActorsByName(name);
    }

    @PostMapping

    public Actors createActor(@RequestBody Actors actors){
       return  actorsService.saveActor(actors);
    }
    @GetMapping("/top100")
    public List<Actors> getTop100Actors() {
        return actorsService.getTop100Actors();
    }
}


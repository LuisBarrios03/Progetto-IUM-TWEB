package com.example.javaserver.actors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ActorsService {
    //define object repository
    private final ActorsRepository actorsRepository;

    @Autowired
    public ActorsService(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    //Return all id name role actors
    List<Actors>getAllActors() {
        return actorsRepository.findAll();
    }

    public List<Actors> getActorsByName(String name) {
        return actorsRepository.findActorsByNameContains(name);
    }
    public List<Actors> getActorsByRole(String role) {
        return actorsRepository.findActorsByRole(role);
    }
    public Actors saveActor(Actors actor) {
        return actorsRepository.save(actor);
    }
    /*public void deleteActor(Long id) {
        actorsRepository.deleteById(id);
    }*/

    /*public List<Actors> getTop100Actors() {
        return actorsRepository.findTop100ByOrderByIdAsc();
    }
*/
    public List<Actors> getTop100Actors() {
        List<Actors> actors = actorsRepository.findTop100ByOrderByIdAsc();
        System.out.println("Actors fetched: " + actors.size()); // Log per verificare il numero di attori
        actors.forEach(actor -> System.out.println(actor.getName()));  // Log per vedere i nomi degli attori
        return actors;
    }

}

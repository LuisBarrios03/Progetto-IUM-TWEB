package com.example.javaserver.crews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/crews")
public class CrewsController {
    private final CrewsService crewsService;

    @Autowired
    public CrewsController(CrewsService crewsService) {
        this.crewsService = crewsService;
    }

    @GetMapping
    public ResponseEntity<List<Crews>> getAllCrews() {
        List<Crews> crews = crewsService.getAllCrews();

        if (crews == null || crews.isEmpty()) {
            // Restituisce 404 (Not Found) se la lista è vuota o null
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce 200 (OK) con la lista dei crews
        return ResponseEntity.ok(crews);
    }


    @GetMapping("find/{nameMovie}")
    public ResponseEntity<List<Crews>> findCrewsByName(@PathVariable String nameMovie) {
        List<Crews> crews = crewsService.getFindByMovieName(nameMovie);

        if (crews == null || crews.isEmpty()) {
            // Restituisce 404 (Not Found) se non ci sono risultati
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Restituisce 200 (OK) con la lista dei crews
        return ResponseEntity.ok(crews);
    }
    @GetMapping("find-by-id/{id}")
    public ResponseEntity<List<Crews>> findCrewsById(@PathVariable Long id) {
        List<Crews> crews = crewsService.getByid(id);

        if(crews == null && crews.isEmpty()) { return  ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(crews);
    }

}

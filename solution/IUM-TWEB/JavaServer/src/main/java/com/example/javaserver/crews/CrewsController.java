package com.example.javaserver.crews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * REST controller for managing crews.
 */
@Controller
@RequestMapping("crews")
public class CrewsController {
    private final CrewsService crewsService;

    /**
     * Constructs a CrewsController with the specified CrewsService.
     *
     * @param crewsService the service for managing crews
     */
    @Autowired
    public CrewsController(CrewsService crewsService) {
        this.crewsService = crewsService;
    }

    /**
     * Retrieves crews by the specified ID.
     *
     * @param id the ID of the crew
     * @return a ResponseEntity containing the list of crews
     */
    @GetMapping("id/{id}")
    public ResponseEntity<List<Map<String, Object>>> findCrewsById(@PathVariable Long id) {
        List<Map<String, Object>> crews = crewsService.getByid(id);

        if (crews == null || crews.isEmpty()) {
            // Returns 404 (Not Found) if no crews are found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Returns 200 (OK) with the list of crews
        return ResponseEntity.ok(crews);
    }
}
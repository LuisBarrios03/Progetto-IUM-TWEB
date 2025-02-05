package com.example.javaserver.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing Posters entities.
 */
@RestController
@RequestMapping("/posters")
public class PostersController {

    private final PostersService postersService;

    @Autowired
    public PostersController(PostersService postersService) {
        this.postersService = postersService;
    }

    /**
     * Retrieves posters by the specified ID.
     *
     * @param id the ID of the poster
     * @return a ResponseEntity containing a list of posters with the specified ID
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<List<Posters>> getPosterById(@PathVariable Long id) {
        List<Posters> poster = postersService.getPostersById(id);
        if (poster == null || poster.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(poster);
    }
}
package com.example.javaserver.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/posters")
public class PostersController {
    private final PostersService postersService;
    @Autowired
    public PostersController(PostersService postersService) {
        this.postersService = postersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Posters>> getAllPosters() {
        List<Posters> poster = postersService.getPosters();
        if(poster == null || poster.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(poster);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<List<Posters>> getPosterById(@PathVariable Long id) {
        List<Posters> poster = postersService.getPostersById(id);
        if(poster == null || poster.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(poster);
    }
}

package com.example.javaserver.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/posters")
public class PostersController {
    private final PostersRepository postersRepository;
    @Autowired
    public PostersController(PostersRepository postersRepository) {
        this.postersRepository = postersRepository;
    }

    @GetMapping("/")
    public List<Posters> getAllPosters() {
        return postersRepository.getPosters();
    }
}

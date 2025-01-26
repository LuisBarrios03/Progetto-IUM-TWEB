package com.example.javaserver.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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

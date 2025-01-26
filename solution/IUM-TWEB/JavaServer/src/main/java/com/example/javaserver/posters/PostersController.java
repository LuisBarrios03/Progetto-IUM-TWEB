package com.example.javaserver.posters;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Posters> getAllPosters() {
        return postersService.getPosters();
    }
}

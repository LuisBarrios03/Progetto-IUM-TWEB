package com.example.javaserver.crews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/Crews")
public class CrewsController {
    private final CrewsService crewsService;

    @Autowired
    public CrewsController(CrewsService crewsService) {
        this.crewsService = crewsService;
    }

    @GetMapping
    public List<Crews> getAllCrews() {
        return crewsService.getAllCrews();
    }

    @GetMapping("find-movie-by-name/{nameMovie}")
    public List<Crews> findCrewsByName(@PathVariable String nameMovie) {
        return crewsService.getAllCrews();
    }
}

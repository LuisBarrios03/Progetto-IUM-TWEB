package com.example.javaserver.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studios")
public class StudiosController {
    @Autowired
    private StudiosService studiosService;

    public StudiosController(StudiosService studiosService) {
        this.studiosService = studiosService;
    }

    @GetMapping
    public List<Studios> getAllStudios() {
        return studiosService.getAllStudios();
    }

    //cerco i film che uno studio ha girato tramite il nome dello studio
    @GetMapping("/studio-by-movie")
    public List<String> getStudioByMovie(@RequestParam String movieName) {
        return studiosService.getStudiosByStudioByName(movieName);
    }

    //Conta il numero di film prodotto da ogni studio
    @GetMapping("/num-films-by-studio")
    public List<Object[]> getNumFilmsByStudio() {
        return studiosService.getFindNumFilmsByStudio();
    }

    //Cerca i film girati da uno studio tramite il nome dello studio
    @GetMapping("/movies-by-studio")
    public List<String> getMoviesByStudio(@RequestParam String studioName) {
        return studiosService.getMoviesByStudio(studioName);
    }

    // Stampa tutti gli studio con i relativi film girati
    @GetMapping("/studios-with-movies")
    public List<Object[]> getStudiosWithMovies() {
        return studiosService.getStudiosWithMovies();
    }

}

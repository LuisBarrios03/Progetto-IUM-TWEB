package com.example.javaserver.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/")
    public List<Studios> getAllStudios() {
        return studiosService.getAllStudios();
    }

    //cerco i film che uno studio ha girato tramite il nome dello studio
    @GetMapping("/studio-by-movie/{movieName}")
    public ResponseEntity<List<Object[]>> getStudioByMovie(@PathVariable String movieName){
        List<Object[]> studios = studiosService.getStudiosByStudioByName(movieName);
        if (studios == null || studios.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(studios);

    }

    //Conta il numero di film prodotto da ogni studio
    @GetMapping("/num-films-by-studio/{studioName}")
    public ResponseEntity<List<Object[]>> getNumFilmsByStudio(@PathVariable String studioName){
        List<Object[]> studios = studiosService.getFindNumFilmsByStudio(studioName);
        if (studios == null || studios.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(studios);
    }

    //Cerca i film girati da uno studio tramite il nome dello studio
    @GetMapping("/movies-by-studio/{studioName}")
    public ResponseEntity<List<Object[]>> getMoviesByStudio(@PathVariable String studioName) {
        List<Object[]> studios = studiosService.getMoviesByStudio(studioName);
        if (studios == null || studios.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(studios);

    }

    // Stampa tutti gli studio con i relativi film girati
    @GetMapping("/studios-with-movies")
    public ResponseEntity<List<Object[]>> getStudiosWithMovies(){
        List<Object[]> studios = studiosService.getStudiosWithMovies();
        if (studios == null || studios.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
        return ResponseEntity.ok(studios);
    }


}

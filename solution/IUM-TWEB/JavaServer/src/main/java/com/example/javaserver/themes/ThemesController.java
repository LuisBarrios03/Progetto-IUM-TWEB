package com.example.javaserver.themes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
public class ThemesController {
    @Autowired
    private final ThemesService themesService;

    public ThemesController(ThemesService themesService) {
        this.themesService = themesService;
    }

    @GetMapping("/")
    public List<Themes> getAllThemes() {
        return themesService.getAllThemes();
    }

    @GetMapping("/themes-by-movie/{movieName}")
    public ResponseEntity<List<Object[]>> getThemesByMovie(@PathVariable String movieName){
        List<Object[]> themes = themesService.getThemesByMovieName(movieName);
        if(themes == null || themes.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        return ResponseEntity.ok(themes);
    }
}

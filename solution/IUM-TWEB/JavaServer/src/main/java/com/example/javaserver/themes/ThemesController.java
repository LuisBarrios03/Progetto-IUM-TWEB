package com.example.javaserver.themes;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Themes> getAllThemes() {
        return themesService.getAllThemes();
    }

    @GetMapping("/themes-by-movie")
    public List<String> getThemesByMovie(@RequestParam String movieName) {
        return themesService.getThemesByMovieName(movieName);
    }
}

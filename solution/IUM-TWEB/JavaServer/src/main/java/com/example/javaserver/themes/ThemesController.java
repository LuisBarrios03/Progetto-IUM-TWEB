package com.example.javaserver.themes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller for managing Themes entities.
 */
@RestController
@RequestMapping("themes")
public class ThemesController {
    @Autowired
    private final ThemesService themesService;

    /**
     * Constructs a ThemesController with the specified ThemesService.
     *
     * @param themesService the service for managing themes
     */
    public ThemesController(ThemesService themesService) {
        this.themesService = themesService;
    }

    /**
     * Finds themes by the specified ID.
     *
     * @param id the ID of the theme
     * @return a ResponseEntity containing a list of themes
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<List<Map<String, Object>>> GetById(@PathVariable Long id) {
        List<Map<String, Object>> themes = themesService.getThemesById(id);
        if (themes == null || themes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(themes);
    }
}

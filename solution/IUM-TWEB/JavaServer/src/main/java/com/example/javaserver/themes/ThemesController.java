package com.example.javaserver.themes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("themes")
public class ThemesController {
    @Autowired
    private final ThemesService themesService;

    public ThemesController(ThemesService themesService) {
        this.themesService = themesService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Map<String, Object>>> GetById(@PathVariable Long id){
        List<Map<String, Object>> themes = themesService.getThemesById(id);
        if(themes == null || themes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(themes);
    }
}

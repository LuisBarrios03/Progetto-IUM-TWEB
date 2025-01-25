package com.example.javaserver.languages;

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
@RequestMapping("/languages")
public class LanguagesController {
    private final LanguagesService languagesService;
    @Autowired
    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping("/")
    public List<Languages> getAllLanguages() {
        return languagesService.getAllLanguages();
    }
    @GetMapping("/{language}")
    public List<Languages> findLanguages(@RequestParam String language) {
        return languagesService.findLanguage(language);
    }

    @GetMapping("/{type}")
    public List<Languages> findLanguagesByType(@RequestParam String type) {
        return languagesService.findLanguagesByType(type);
    }

    //to add: GET ALL

    @GetMapping("/")
    public List<Languages> getTop100Languages() {
        return languagesService.getTop100Languages();
    }

}

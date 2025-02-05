package com.example.javaserver.languages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller for managing languages.
 */
@RestController
@RequestMapping("/languages")
public class LanguagesController {
    private final LanguagesService languagesService;

    /**
     * Constructs a LanguagesController with the specified LanguagesService.
     *
     * @param languagesService the service for managing languages
     */
    @Autowired
    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    /**
     * Retrieves languages by the specified ID.
     *
     * @param language the ID of the language
     * @return a ResponseEntity containing the list of languages
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<List<Map<String, Object>>> findLanguages(@PathVariable Long language) {
        List<Map<String, Object>> languages = languagesService.findLanguage(language);
        if (languages == null || languages.isEmpty()) {
            // Returns 404 (Not Found) if no languages are found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Returns 200 (OK) with the list of languages
        return ResponseEntity.ok(languages);
    }
}
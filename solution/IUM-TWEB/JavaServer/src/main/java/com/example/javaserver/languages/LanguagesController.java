package com.example.javaserver.languages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/languages")
public class LanguagesController {
    private final LanguagesService languagesService;
    @Autowired
    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping("/")
    public ResponseEntity <List<Languages>> getAllLanguages() {
        List<Languages> languages = languagesService.getAllLanguages();
        if(languages == null || languages.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/name/{language}")
    public ResponseEntity <List<Languages>> findLanguages(@PathVariable String language) {
        List<Languages> languages = languagesService.findLanguage(language);
        if(languages == null || languages.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/type/{type}")
    public  ResponseEntity <List<Languages>> findLanguagesByType(@PathVariable String type) {
        List<Languages> languages = languagesService.findLanguagesByType(type);
        if(languages == null || languages.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(languages);
    }

    //to add: GET ALL

    @GetMapping("/get100")
    public List<Languages> getTop100Languages() {
        return languagesService.getTop100Languages();
    }

}

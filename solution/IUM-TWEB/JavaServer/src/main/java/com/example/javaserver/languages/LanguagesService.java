package com.example.javaserver.languages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for managing languages.
 */
@Service
public class LanguagesService {
    private final LanguagesRepository languagesRepository;

    /**
     * Constructs a LanguagesService with the specified LanguagesRepository.
     *
     * @param languagesRepository the repository for managing languages
     */
    @Autowired
    public LanguagesService(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
    }

    /**
     * Retrieves languages by the specified ID.
     *
     * @param id the ID of the language
     * @return a list of maps containing language details
     */
    public List<Map<String, Object>> findLanguage(Long id) {
        List<Object[]> results = languagesRepository.findLanguageByid(id);
        List<Map<String, Object>> languages = new ArrayList<>();
        for (Object[] row : results) {
            Map<String, Object> language = new HashMap<>();
            language.put("id", row[0]);
            languages.add(language);
        }
        return languages;
    }
}
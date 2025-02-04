package com.example.javaserver.themes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for managing Themes entities.
 */
@Service
public class ThemesService {
    private final ThemesRepository themesRepository;

    /**
     * Constructs a ThemesService with the specified ThemesRepository.
     *
     * @param themesRepository the repository for managing themes
     */
    @Autowired
    public ThemesService(ThemesRepository themesRepository) {
        this.themesRepository = themesRepository;
    }

    /**
     * Gets themes by the specified ID.
     *
     * @param id the ID of the theme
     * @return a list of themes
     */
    public List<Map<String, Object>> getThemesById(Long id) {
        List<Object[]> results = themesRepository.findThemesByID(id);
        List<Map<String, Object>> themes = new ArrayList<>();
        for (Object[] obj : results) {
            Map<String, Object> theme = new HashMap<>();
            theme.put("id", obj[0]);
            theme.put("theme", obj[1]);
            themes.add(theme);
        }
        System.out.println(themes);
        return themes;
    }
}

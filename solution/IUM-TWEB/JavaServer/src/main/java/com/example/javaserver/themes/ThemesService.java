package com.example.javaserver.themes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemesService {
    private final ThemesRepository themesRepository;

    @Autowired
    public ThemesService(ThemesRepository themesRepository) {
        this.themesRepository = themesRepository;
    }

    public List<Themes> getAllThemes() {
        return themesRepository.findAll();
    }

    // trovo i temi  in base al nome del film
    public List<Object[]> getThemesByMovieName(String movieName) {
        return themesRepository.findThemesByMovieName(movieName);
    }


}

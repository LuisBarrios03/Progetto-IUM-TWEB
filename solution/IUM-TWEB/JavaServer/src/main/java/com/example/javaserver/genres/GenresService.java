package com.example.javaserver.genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenresService {
    private final GenresRepostory genresRepostory;

    @Autowired
    public GenresService(GenresRepostory genresRepostory) {
        this.genresRepostory = genresRepostory;
    }

    public List<Genres> getAllGenres(){
        return genresRepostory.findAll();
    }
    public List<Genres> getGenreById(Long id){
        return genresRepostory.findGenreById(id);
    }
    public List<Map<String, Object>> getAllGenre(){
        List<Object[]> results = genresRepostory.allGenres();
        List<Map<String, Object>> genres = new ArrayList<>();
        for (Object[] row : results) {
            Map<String, Object> genre = new HashMap<>();
            genre.put("genre", row[0]);
            genres.add(genre);
        }
        return genres;
    }
}

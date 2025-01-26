package com.example.javaserver.genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

package com.example.javaserver.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudiosService {
    private final StudiosRepository studiosRepository;

    @Autowired
    public StudiosService(StudiosRepository studiosRepository) {
        this.studiosRepository = studiosRepository;
    }

    // ritorna tutti gli studio con i film prodotti
    public List<Studios> getAllStudios() {
        return studiosRepository.findAll();
    }

    // trovo lo studio in base al nome del film per vedere da quale studio è stato prodotto un film
    public List<String> getStudiosByStudioByName(String studio){
        return studiosRepository.findStudioByMovieByName(studio);
    }

    //conto il numero di film prodotto da ogni studio
    public List<Object[]> getFindNumFilmsByStudio(){
        return studiosRepository.countMoviesByStudio();
    }

    //cerco i film che uno studio ha girato tramite il nome dello studio
    public List<String> getMoviesByStudio(String studioName) {
        return studiosRepository.findMoviesByStudioName(studioName);
    }

    //stampo tutti gli studio con i relativi film girati
    public List<Object[]> getStudiosWithMovies() {
        return studiosRepository.findStudiosWithMovieNames();
    }


}

package com.example.javaserver.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Studios entities.
 */
@Service
public class StudiosService {
    private final StudiosRepository studiosRepository;

    /**
     * Constructor for StudiosService.
     *
     * @param studiosRepository the repository for Studios entities
     */
    @Autowired
    public StudiosService(StudiosRepository studiosRepository) {
        this.studiosRepository = studiosRepository;
    }

    /**
     * Retrieves all studios.
     *
     * @return a list of all studios
     */
    public List<Studios> getAllStudios() {
        return studiosRepository.findAll();
    }

    /**
     * Finds studios by movie name.
     *
     * @param studio the name of the studio
     * @return a list of studios for the specified movie name
     */
    public List<Object[]> getStudiosByStudioByName(String studio) {
        return studiosRepository.findStudioByMovieByName(studio);
    }

    /**
     * Counts the number of films produced by each studio.
     *
     * @param studioName the name of the studio
     * @return the number of films produced by the specified studio
     */
    public List<Object[]> getFindNumFilmsByStudio(String studioName) {
        return studiosRepository.countMoviesByStudio(studioName);
    }

    /**
     * Finds movies by studio name.
     *
     * @param studioName the name of the studio
     * @return a list of movies for the specified studio name
     */
    public List<Object[]> getMoviesByStudio(String studioName) {
        return studiosRepository.findMoviesByStudioName(studioName);
    }

    /**
     * Retrieves all studios with their respective movies.
     *
     * @return a list of all studios with their respective movies
     */
    public List<Object[]> getStudiosWithMovies() {
        return studiosRepository.findStudiosWithMovieNames();
    }
}
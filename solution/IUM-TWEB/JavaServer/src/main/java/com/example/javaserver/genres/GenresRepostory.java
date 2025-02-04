package com.example.javaserver.genres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for managing genres.
 */
public interface GenresRepostory extends JpaRepository<Genres, idGenres> {

    /**
     * Retrieves all genres.
     *
     * @return a list of objects containing genre details
     */
    @Query("SELECT DISTINCT g.genre FROM Genres g ")
    List<Object[]> allGenres();
}
package com.example.javaserver.studios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Studios entities.
 */
@Repository
public interface StudiosRepository extends JpaRepository<Studios, IdStudios> {
    /**
     * Finds studios by movie name.
     *
     * @param movieName the name of the movie
     * @return a list of studios for the specified movie name
     */
    @Query("SELECT s.studio FROM Studios s JOIN s.movie m WHERE m.name = :movieName")
    List<Object[]> findStudioByMovieByName(@Param("movieName") String movieName);

    /**
     * Counts the number of movies produced by each studio.
     *
     * @param studioName the name of the studio
     * @return the number of movies produced by the specified studio
     */
    @Query("SELECT s.studio, COUNT(m.id) FROM Studios s JOIN s.movie m GROUP BY s.studio")
    List<Object[]> countMoviesByStudio(@Param("studioName") String studioName);

    /**
     * Finds movies by studio name.
     *
     * @param studioName the name of the studio
     * @return a list of movies for the specified studio name
     */
    @Query("SELECT m.name FROM Studios s JOIN s.movie m WHERE s.studio = :studioName")
    List<Object[]> findMoviesByStudioName(@Param("studioName") String studioName);

    /**
     * Finds all studios with their respective movies.
     *
     * @return a list of all studios with their respective movies
     */
    @Query("SELECT s.studio, m.name FROM Studios s JOIN s.movie m")
    List<Object[]> findStudiosWithMovieNames();
}
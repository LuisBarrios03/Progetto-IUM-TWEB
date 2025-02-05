package com.example.javaserver.movies;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for managing Movies entities.
 */
@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {

    /**
     * Finds movies by the specified ID.
     *
     * @param id the ID of the movie
     * @return a list of movies
     */
    @Query("select m from Movies m where m.id = :id")
    List<Movies> movieById(@Param("id") Long id);

    /**
     * Finds the latest released movies up to the specified date.
     *
     * @param today the current date
     * @param pageable the pagination information
     * @return a list of latest released movies
     */
    @Query("SELECT m.id, m.name, m.posters.link, m.description FROM Movies m JOIN m.release r WHERE r.date <= :today AND r.date IS NOT NULL ORDER BY r.date DESC")
    List<Object[]> findLatestReleasedMovies(@Param("today") LocalDate today, Pageable pageable);

    /**
     * Finds the top-rated movies for the year 2024 with a rating of 5 or less.
     *
     * @param pageable the pagination information
     * @return a list of top-rated movies
     */
    @Query("SELECT m.id, m.name, m.description, m.date, m.rating, m.tagline, m.minute, p.link FROM Movies m JOIN m.posters p WHERE m.rating IS NOT NULL AND m.date = 2024 AND m.rating <= 5 ORDER BY m.rating DESC")
    List<Object[]> findTopRatedMovies(Pageable pageable);

    /**
     * Searches for movies based on various criteria.
     *
     * @param title the title of the movie
     * @param genres the genres of the movie
     * @param duration the duration of the movie
     * @param rating the rating of the movie
     * @param year the release year of the movie
     * @param pageable the pagination information
     * @return a list of movies matching the criteria
     */
    @Query("SELECT DISTINCT m.id, m.name, m.posters.link, m.rating FROM Movies m JOIN m.genre g WHERE (LOWER(m.name) LIKE LOWER(CONCAT('%', :title, '%')) OR :title IS NULL) AND (g.genre IN :genres OR :genres IS NULL) AND (m.minute >= :duration OR :duration IS NULL) AND (m.rating <= :rating OR :rating IS NULL) AND (m.date = :year OR :year IS NULL)")
    List<Object[]> searchMovies(@Param("title") String title, @Param("genres") List<String> genres, @Param("duration") Integer duration, @Param("rating") Double rating, @Param("year") Integer year, Pageable pageable);

    /**
     * Finds movies by the specified actor's name.
     *
     * @param actorName the name of the actor
     * @return a list of movies featuring the actor
     */
    @Query("SELECT m.id, m.rating, a.role, m.name, m.posters.link FROM Movies m JOIN m.actors a WHERE a.name LIKE %:actorName%")
    List<Object[]> findMoviesByActorName(@Param("actorName") String actorName);

    /**
     * Finds the most recent movies for the year 2024 with a rating of 5 or less.
     *
     * @param pageable the pagination information
     * @return a list of most recent movies
     */
    @Query("SELECT m.id, m.name, m.description, m.date, m.rating, m.tagline, m.minute, p.link FROM Movies m JOIN m.posters p WHERE m.rating IS NOT NULL AND m.date = 2024 AND m.rating <= 5 ORDER BY m.date ASC")
    List<Object[]> findMostRecent(Pageable pageable);
}
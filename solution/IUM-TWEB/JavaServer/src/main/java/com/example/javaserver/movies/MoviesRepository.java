package com.example.javaserver.movies;

import com.example.javaserver.genres.Genres;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    //trova i film per nome
    @Query("SELECT m from Movies m where m.name like %:name%") List<Movies> moviesByName(String name);
    //trova film per id
    @Query("select m from Movies m where m.id = :id") List<Movies> movieById(Long id);
    //trova i film per anno
    @Query("select m from Movies m where m.date = :date") List<Movies> moviesByDate(Integer date);
    //trova i film per rating
    @Query("select m from Movies m where m.rating = :rating") List<Movies> moviesByRating(Float rating);





    @Query("SELECT m.id, m.name , m.posters.link ,m.description FROM Movies m JOIN m.release r WHERE  r.date <= :today AND r.date IS NOT NULL ORDER BY r.date DESC")
    List<Object[]> findLatestReleasedMovies(@Param("today") LocalDate today , Pageable pageable);


    @Query("SELECT m.id , m.name , m.description, m.date, m.rating,m.tagline,m.minute,p.link FROM Movies m JOIN m.posters p WHERE m.rating IS NOT NULL AND  m.date = 2024  AND  m.rating<=5 ORDER BY m.rating DESC")
    List<Object[]> findTopRatedMovies(Pageable pageable);

    @Query("SELECT DISTINCT m.id,m.name,m.posters.link,m.rating FROM Movies m " +
            "JOIN m.genre g " +   // Assicurati che 'genre' sia la proprietà corretta della classe 'Movies'
            "WHERE (LOWER(m.name) LIKE LOWER(CONCAT('%', :title, '%')) OR :title IS NULL)  " +
            "AND (g.genre IN :genres OR :genres IS NULL) " +  // Assicurati che 'g.genre' sia la proprietà corretta della classe 'Genres'
            "AND (m.minute <= :duration OR :duration IS NULL) " +
            "AND (m.rating >= :rating OR :rating IS NULL) " +
            "AND (m.date = :year OR :year IS NULL)")
    List<Object[]> searchMovies(
            @Param("title") String title,
            @Param("genres") List<String> genres,
            @Param("duration") Integer duration,
            @Param("rating") Double rating,
            @Param("year") Integer year,
            Pageable pageable
    );

}

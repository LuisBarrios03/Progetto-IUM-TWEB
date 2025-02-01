package com.example.javaserver.movies;

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





    @Query("SELECT m FROM Movies m JOIN m.release r WHERE  r.date <= :today AND r.date IS NOT NULL ORDER BY r.date DESC")
    List<Movies> findLatestReleasedMovies(@Param("today") LocalDate today , Pageable pageable);
    @Query("SELECT m FROM Movies m WHERE m.rating IS NOT NULL AND  m.date = 2024  AND  m.rating<=5 ORDER BY m.rating DESC")
    List<Movies> findTopRatedMovies(Pageable pageable);

}

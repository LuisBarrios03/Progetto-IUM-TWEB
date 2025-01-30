package com.example.javaserver.movies;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


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



    @Query("SELECT m FROM Movies m WHERE m.date = 2024 ORDER BY m.date DESC LIMIT 5")
    List<Movies> findTop5RecentMovies();
    @Query("SELECT m FROM Movies m ORDER BY m.rating DESC")
    Page<Movies> findTopRatedMovies(Pageable pageable);

}

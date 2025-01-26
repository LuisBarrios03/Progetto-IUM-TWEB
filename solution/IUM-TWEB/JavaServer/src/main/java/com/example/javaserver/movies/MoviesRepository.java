package com.example.javaserver.movies;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface MoviesRepository {
    //trova i film per nome
    @Query("SELECT m from Movies m where m.name like %:name%") List<Movies> moviesByName(String name);
    //trova film per id
    @Query("select m from Movies m where m.id = :id") String movieById(Long id);
    //trova i film per anno
    @Query("select m from Movies m where m.date = :date") List<Movies> moviesByDate(int date);
    //trova i film per rating
    @Query("select m from Movies m where m.rating = :rating") List<Movies> moviesByRating(Float rating);

}

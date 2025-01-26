package com.example.javaserver.themes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemesRepository extends JpaRepository<Themes, Long> {
    // Query per ottenere tutti i temi con i relativi film
    //trovo i temi  in base al nome del film
    @Query("SELECT t.theme FROM Themes t JOIN t.movies m WHERE m.name = :movieName")
    List<String> findThemesByMovieName(@Param("movieName") String movieName);
}
package com.example.javaserver.genres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenresRepostory extends JpaRepository<Genres,idGenres> {

    // Trova un genere per id
    @Query("SELECT g FROM Genres g WHERE g.id = :id")
    List<Genres> findGenreById(@Param("id") Long id);

    @Query("SELECT DISTINCT g.genre FROM Genres g ")
    List<Object[]>allGenres();

}

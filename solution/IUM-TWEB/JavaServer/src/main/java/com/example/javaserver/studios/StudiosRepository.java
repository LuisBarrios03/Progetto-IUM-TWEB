package com.example.javaserver.studios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudiosRepository extends JpaRepository<Studios, Long> {
    // Query personalizzate per trovare gli studi e i loro film
    //trovo lo studio in base al nome del film per vedere da quale studio è stato prodotto un film
    @Query("SELECT s.studio FROM Studios s JOIN s.movie m WHERE m.name= :movieName")
    List<String> findStudioByMovieByName(@Param("movieName") String movieName);

    //conta il numero di film prodotti da uno studio
    @Query("SELECT s.studio, COUNT(m.id) FROM Studios s JOIN s.movie m GROUP BY s.studio")
    List<Object[]> countMoviesByStudio();

    //cerco i film che uno studio ha girato tramite il nome dello studio
    @Query("SELECT m.name FROM Studios s JOIN s.movie m WHERE s.studio = :studioName")
    List<String> findMoviesByStudioName(@Param("studioName") String studioName);

    //stampo tutti gli studio con i relativi film girati
    @Query("SELECT s.studio, m.name FROM Studios s JOIN s.movie m")
    List<Object[]> findStudiosWithMovieNames();
}
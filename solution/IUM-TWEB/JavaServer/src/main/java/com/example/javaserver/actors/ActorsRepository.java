package com.example.javaserver.actors;

import com.example.javaserver.movies.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

// Repositories
@Repository
public interface ActorsRepository extends JpaRepository<Actors, idActors> {

    //1.    Find actors by movie name
    @Query("SELECT a FROM Actors a INNER JOIN FETCH a.movie m WHERE lower( m.name) = lower( :name)")
    List<Actors> findActorsByMovie(@Param("name") String movieName);

    //2. Fetch movies participated by a specific actor by their name
    @Query("SELECT m.id ,m.name,m.rating FROM Movies m WHERE m.name = : actorName ")
    List<Movies> findMoviesByActorName(@Param("actorName") String actorName);

}

package com.example.javaserver.actors;

import com.example.javaserver.movies.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing actors.
 */
@Repository
public interface ActorsRepository extends JpaRepository<Actors, idActors> {

    /**
     * Finds movies by the specified actor name.
     *
     * @param actorName the name of the actor
     * @return a list of movies featuring the specified actor
     */
    @Query("SELECT m.id, m.name, m.rating FROM Movies m WHERE m.name = :actorName")
    List<Movies> findMoviesByActorName(@Param("actorName") String actorName);
}
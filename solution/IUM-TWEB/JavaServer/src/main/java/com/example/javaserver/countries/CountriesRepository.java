package com.example.javaserver.countries;

import com.example.javaserver.movies.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountriesRepository extends JpaRepository<Countries, idCountries> {

    // Query per ottenere tutti i paesi per i film con rating maggiore di una certa soglia
    @Query("SELECT c FROM Countries c INNER JOIN c.movie m WHERE m.rating > :rating")
    List<Countries> findByMovieRatingGreaterThan(@Param("rating") Double rating);
}

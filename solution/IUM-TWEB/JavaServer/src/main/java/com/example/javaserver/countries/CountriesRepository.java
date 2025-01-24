package com.example.javaserver.countries;

import com.example.javaserver.movies.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CountriesRepository extends JpaRepository<Countries, idCountries> {

    @Query("SELECT c.country FROM Countries c JOIN c.movie m WHERE m.name= :movieName")
    List<String> findCountriesByMovieByName(@Param("movieName") String movieName);

    @Query("SELECT COUNT(m) AS numFilms, c.country AS countryName FROM Movies m JOIN m.countries c GROUP BY c.country")
    List<Object[]> findNumFilmsByCountry();

}

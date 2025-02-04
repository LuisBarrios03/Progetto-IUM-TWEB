package com.example.javaserver.countries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing countries.
 */
@Repository
public interface CountriesRepository extends JpaRepository<Countries, idCountries> {

    /**
     * Finds countries by the specified movie ID.
     *
     * @param id the ID of the movie
     * @return a list of countries associated with the specified movie
     */
    @Query("SELECT c.country FROM Countries c JOIN c.movie m WHERE m.id = :id")
    List<Object[]> findCountriesByCountryId(@Param("id") Long id);
}
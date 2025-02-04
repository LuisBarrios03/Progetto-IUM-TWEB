package com.example.javaserver.releases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Releases entities.
 */
@Repository
public interface ReleasesRepository extends JpaRepository<Releases, IdReleases>  {

    /**
     * Finds releases by country.
     *
     * @param country the country of the releases
     * @return a list of releases for the specified country
     */
    @Query("SELECT r.date, r.type, r.rating, m.name " +
            "FROM Releases r JOIN r.movie m " +
            "WHERE r.country = :country")
    List<Object[]> findReleasesByCountry(@Param("country") String country);

    /**
     * Counts movies by country.
     *
     * @param country the country of the releases
     * @return the number of movies released in the specified country
     */
    @Query("SELECT COUNT(r) FROM Releases r WHERE r.country = :country")
    Long countMoviesByCountry(@Param("country") String country);

    /**
     * Finds releases by movie name.
     *
     * @param movieName the name of the movie
     * @return a list of releases for the specified movie name
     */
    @Query("SELECT r.country, r.date, r.type, r.rating " +
            "FROM Releases r JOIN r.movie m " +
            "WHERE m.name = :movieName")
    List<Object[]> findReleasesByMovieName(@Param("movieName") String movieName);
}
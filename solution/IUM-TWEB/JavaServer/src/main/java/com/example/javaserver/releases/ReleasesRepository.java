package com.example.javaserver.releases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleasesRepository extends JpaRepository<Releases, IdReleases>  {

    // dato un certo country voglio sapere il type, il rating e name film, date
    @Query("SELECT r.date, r.type, r.rating, m.name " +
            "FROM Releases r JOIN r.movies m " +
            "WHERE r.country = :country")
    List<Object[]> findReleasesByCountry(@Param("country") String country);

    //dato un certo country voglio sapere il numero di film in esso rilasciato
    @Query("SELECT COUNT(r) FROM Releases r WHERE r.country = :country")
    Long countMoviesByCountry(@Param("country") String country);

    //dato il nome del film voglio sapere country,date,type,rating
    @Query("SELECT r.country, r.date, r.type, r.rating " +
            "FROM Releases r JOIN r.movies m " +
            "WHERE m.name = :movieName")
    List<Object[]> findReleasesByMovieName(@Param("movieName") String movieName);

}

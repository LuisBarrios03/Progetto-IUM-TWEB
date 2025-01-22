package com.example.javaserver.languages;

import com.example.javaserver.actors.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;


@Repository
public interface LanguagesRepository  extends JpaRepository<Languages, Long> {
    //trova le lingue per nome della lingua
    @Query("SELECT l FROM Languages l WHERE l.language LIKE %:language%")
    List<Languages> findLanguage(@Param("language") String language);


    //trova le lingue per tipologia
    @Query("SELECT l FROM Languages l WHERE l.type LIKE %:type%")
    List<Languages> findLanguagesByType(@Param("type") String type);


    //test primi 100
    List<Languages>findTop100ByOrderByIdAsc();
}

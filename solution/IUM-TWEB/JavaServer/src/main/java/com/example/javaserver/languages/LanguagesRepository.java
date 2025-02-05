package com.example.javaserver.languages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing languages.
 */
@Repository
public interface LanguagesRepository extends JpaRepository<Languages, LanguagesId> {

    /**
     * Retrieves languages by the specified ID.
     *
     * @param id the ID of the language
     * @return a list of objects containing language details
     */
    @Query("SELECT l.language, l.type FROM Languages l WHERE l.id = :id")
    List<Object[]> findLanguageByid(@Param("id") Long id);
}
package com.example.javaserver.themes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Themes entities.
 */
@Repository
public interface ThemesRepository extends JpaRepository<Themes, IdThemes> {
    /**
     * Finds themes by the specified ID.
     *
     * @param id the ID of the theme
     * @return a list of themes
     */
    @Query("SELECT t.id, t.theme FROM Themes t WHERE t.id = :id")
    List<Object[]> findThemesByID(@Param("id") Long id);
}
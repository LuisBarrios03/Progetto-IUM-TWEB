package com.example.javaserver.themes;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

/**
 * Represents a theme entity.
 */
@Entity
@Table(name = "themes")
@IdClass(IdThemes.class)
public class Themes {
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Long id;

    @Id
    @Column(name = "theme", nullable = false, columnDefinition = "TEXT")
    private String theme;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Movies movie;

    /**
     * Default constructor.
     */
    public Themes() {}

    /**
     * Constructs a Themes entity with the specified id and theme.
     *
     * @param id the id of the theme
     * @param theme the theme name
     */
    public Themes(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    /**
     * Gets the id of the theme.
     *
     * @return the id of the theme
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the theme.
     *
     * @param id the id of the theme
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the theme name.
     *
     * @return the theme name
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets the theme name.
     *
     * @param theme the theme name
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }
}

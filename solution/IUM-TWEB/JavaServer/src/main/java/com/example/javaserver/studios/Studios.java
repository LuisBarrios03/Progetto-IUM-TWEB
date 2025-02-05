package com.example.javaserver.studios;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

/**
 * Entity class representing a studio.
 */
@Entity
@Table(name = "studios")
@IdClass(IdStudios.class)
public class Studios {

    /**
     * The unique identifier for the studio.
     */
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Long id;

    /**
     * The name of the studio.
     */
    @Id
    @Column(name = "studio", nullable = false, columnDefinition = "TEXT")
    private String studio;

    /**
     * The movie associated with the studio.
     */
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Movies movie;

    /**
     * Default constructor for the Studios class.
     */
    public Studios() {}

    /**
     * Constructor for the Studios class.
     *
     * @param id the unique identifier for the studio
     * @param studio the name of the studio
     */
    public Studios(Long id, String studio) {
        this.id = id;
        this.studio = studio;
    }

    /**
     * Gets the unique identifier for the studio.
     *
     * @return the unique identifier for the studio
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the studio.
     *
     * @param id the unique identifier for the studio
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the studio.
     *
     * @return the name of the studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Sets the name of the studio.
     *
     * @param studio the name of the studio
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }
}
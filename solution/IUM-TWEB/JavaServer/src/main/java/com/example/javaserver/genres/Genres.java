package com.example.javaserver.genres;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

/**
 * Entity class representing a genre.
 */
@Entity
@Table(name= "genres")
@IdClass(Genres.class)
public class Genres {
    @Id
    private Long id;

    @Id
    @Column(name= "genre", nullable= false, columnDefinition= "TEXT")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Movies movie;

    /**
     * Default constructor.
     */
    public Genres() {}

    /**
     * Constructs a Genres with the specified ID and genre.
     *
     * @param id the ID of the genre
     * @param genre the name of the genre
     */
    public Genres(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
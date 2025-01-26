package com.example.javaserver.genres;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name= "genres")
@IdClass(Genres.class)
public class Genres {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    private Long id;

    @Id
    @Column(name= "genre", nullable= false, columnDefinition= "TEXT")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Movies movie;

    //constructor
    public Genres() {}

    public Genres(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }


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

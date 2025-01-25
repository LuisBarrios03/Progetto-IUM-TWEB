package com.example.javaserver.posters;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name= "posters")
public class Posters {
    @EmbeddedId
    private PostersId ID;

    //foreign key?
    @ManyToOne
    @MapsId("id") // Mappa il campo id della chiave composta
    @JoinColumn(name = "id") // Nome della colonna che rappresenta la foreign key
    private Movies movie;

    @Column(name= "id", nullable= false, columnDefinition= "INTEGER")
    private Long id;
    @Column(name= "link", nullable= false, columnDefinition= "TEXT")
    private String link;

    //constructor
    public Posters() {}

    public Posters(Long id, String link) {
        this.id = id;
        this.link = link;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

}

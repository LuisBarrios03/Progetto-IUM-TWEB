package com.example.javaserver.languages;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name= "languages")
public class Languages {

    //chiave composta
    @EmbeddedId
    private LanguagesId ID;

    //foreign key?
    @ManyToOne
    @MapsId("id") // Mappa il campo id della chiave composta
    @JoinColumn(name = "id") // Nome della colonna che rappresenta la foreign key
    private Movies movie;

    //altre colonne
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Long id;
    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private String type;
    @Column(name = "language", nullable = false, columnDefinition = "TEXT")
    private String language;
    //constructor
    public Languages() {}

    public Languages(Long id, String type, String language) {
        this.id = id;
        this.type = type;
        this.language = language;
    }

    // Getters and Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getType() {return type;}
    public void setType(String role) {this.type = type;}

    public String getLanguage() {return language;}
    public void setLanguage(String language) {this.language = language;}
}

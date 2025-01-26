package com.example.javaserver.languages;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name= "languages")
@IdClass(LanguagesId.class)
public class Languages {


    @ManyToOne
    //foreign key?
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Movies movies;

    //altre colonne
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Long id;
    @Id
    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private String type;
    @Id
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

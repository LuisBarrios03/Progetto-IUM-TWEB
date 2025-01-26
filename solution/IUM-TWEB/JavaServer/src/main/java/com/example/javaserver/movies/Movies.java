package com.example.javaserver.movies;

import com.example.javaserver.languages.Languages;
import com.example.javaserver.posters.Posters;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name= "movies")
public class Movies {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "date", nullable = true, columnDefinition = "INTEGER")
    private Integer date;
    @Column(name = "tagline", nullable = true, columnDefinition = "TEXT")
    private String tagline;
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;
    @Column(name = "minute", nullable = true, columnDefinition = "INTEGER")
    private Long minute;
    @Column(name = "rating", nullable = true, columnDefinition = "INTEGER")
    private Float rating;

//collegamento one to many per le altre tabelle
    @OneToMany(mappedBy = "movie")
    private List<Languages> languages;
    @OneToMany(mappedBy = "movie")
    private List<Posters> posters;


    //constructor
    public Movies() {}

    public Movies(Long id, String name, Integer date, String tagline, String description, Long minute, Float rating) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tagline = tagline;
        this.description = description;
        this.minute = minute;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Integer getDate() {return date;}
    public void setDate(Integer date) {this.date = date;}

    public String getTagline() {return tagline;}
    public void setTagline(String tagline) {this.tagline = tagline;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Long getMinute() {return minute;}
    public void setMinute(Long minute) {this.minute = minute;}

    public Float getRating() {return rating;}
    public void setRating(Float rating) {this.rating = rating;}
}

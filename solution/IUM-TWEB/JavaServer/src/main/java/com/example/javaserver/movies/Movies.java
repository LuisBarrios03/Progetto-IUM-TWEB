package com.example.javaserver.movies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.util.Date;

@Entity
@Table(name= "movies")
public class Movies {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "date", nullable = true, columnDefinition = "INTEGER")
    private int date;
    @Column(name = "tagline", nullable = true, columnDefinition = "TEXT")
    private String tagline;
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;
    @Column(name = "minute", nullable = true, columnDefinition = "INTEGER")
    private Long minute;
    @Column(name = "rating", nullable = true, columnDefinition = "INTEGER")
    private Float rating;


    //constructor
    public Movies() {
    }

    public Movies(Long id, String name, int date, String tagline, String description, Long minute, Float rating) {
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

    public int getDate() {return date;}
    public void setDate(int date) {this.date = date;}

    public String getTagline() {return tagline;}
    public void setTagline(String tagline) {this.tagline = tagline;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Long getMinute() {return minute;}
    public void setMinute(Long minute) {this.minute = minute;}

    public Float getRating() {return rating;}
    public void setRating(Float rating) {this.rating = rating;}
}

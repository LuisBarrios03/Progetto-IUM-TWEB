package com.example.javaserver.movies;

import com.example.javaserver.actors.Actors;
import com.example.javaserver.countries.Countries;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "movies")
public class Movies {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    //genera un valore Long che si incrementa, lo salvo in identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "date", nullable = true, columnDefinition = "INTEGER")
    private String date;
    @Column(name = "tagline", nullable = true, columnDefinition = "TEXT")
    private String tagline;
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;
    @Column(name = "minute", nullable = true, columnDefinition = "INTEGER")
    private String minute;
    @Column(name = "rating", nullable = true, columnDefinition = "INTEGER")
    private String rating;


    @OneToMany(mappedBy = "movie")
    private List<Actors> actors;
    @OneToMany(mappedBy = "movie")
    private List<Countries> countries;

    //constructor
    public Movies() {
    }

    public Movies(Long id, String name, String date, String tagline, String description, String minute, String rating) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tagline = tagline;
        this.description = description;
        this.minute = minute;
        this.rating = rating;
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getTagline() {return tagline;}
    public void setTagline(String tagline) {this.tagline = tagline;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getMinute() {return minute;}
    public void setMinute(String minute) {this.minute = minute;}

    public String getRating() {return rating;}
    public void setRating(String rating) {this.rating = rating;}
}

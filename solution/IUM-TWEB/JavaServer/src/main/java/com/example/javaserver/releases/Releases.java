package com.example.javaserver.releases;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "releases")
@IdClass(IdReleases.class)
public class Releases {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Long id;
    @Column(name = "country", nullable = false, columnDefinition = "TEXT")
    private String country;
    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    private Date date;
    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private String type;
    @Column(name = "rating", nullable = true, columnDefinition = "TEXT")
    private String rating;

    @ManyToOne
    // Collega "id" di ReleasesId con la chiave primaria di Movie
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Movies movies; // Relazione molti-a-uno con Movies

    //constructor
    public Releases() {
    }

    public Releases(Long id, String country, Date date, String type, String rating) {
        this.id = id;
        this.country = country;
        this.date = date;
        this.type = type;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getRating() {return rating;}
    public void setRating(String rating) {this.rating = rating;}
}


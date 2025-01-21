package com.example.javaserver.releases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name= "releases")
public class Releases {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    //genera un valore Long che si incrementa, lo salvo in identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identity; //????????

    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Long id;
    @Column(name = "country", nullable = false, columnDefinition = "TEXT")
    private String country;
    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    private String date;
    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private String type;
    @Column(name = "rating", nullable = false, columnDefinition = "TEXT")
    private String rating;


    //constructor
    public Releases() {
    }

    public Releases(Long id, String country, String date, String type, String rating) {
        this.id = id;
        this.country = country;
        this.date = date;
        this.type = type;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getIdentity() {return identity;}
    public void setIdentity(Long identity) {this.identity = identity;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getRating() {return rating;}
    public void setRating(String rating) {this.rating = rating;}
}

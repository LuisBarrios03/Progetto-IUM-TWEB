package com.example.javaserver.movies;

import com.example.javaserver.actors.Actors;
import com.example.javaserver.countries.Countries;
import com.example.javaserver.crews.Crews;
import com.example.javaserver.genres.Genres;
import com.example.javaserver.languages.Languages;
import com.example.javaserver.posters.Posters;
import com.example.javaserver.releases.Releases;
import com.example.javaserver.studios.Studios;
import com.example.javaserver.themes.Themes;
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
    @Column(name = "rating", nullable = true, columnDefinition = "REAL")
    private Double rating;

//collegamento con le altre tabelle
    @OneToMany(mappedBy = "movie")
    private List<Languages> languages;
    @OneToOne(mappedBy = "movie")
    private Posters posters;
    @OneToMany(mappedBy = "movie")
    private List<Actors> actors;
    @OneToMany(mappedBy = "movie")
    private List<Countries> countries;
    @OneToMany(mappedBy = "movie")
    private List<Crews> crews;
    @OneToMany(mappedBy = "movie")
    private List<Genres> genre;
    @OneToMany(mappedBy = "movie")
    private List<Studios> studio;
    @OneToMany(mappedBy = "movie")
    private List<Releases> release;
    @OneToMany(mappedBy = "movie")
    private List<Themes> theme;





    //constructor
    public Movies() {}

    public Movies(Long id, String name, Integer date, String tagline, String description, Long minute, Double rating) {
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

    public Double getRating() {return rating;}
    public void setRating(Double rating) {this.rating = rating;}

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public Posters getPosters() {
        return posters;
    }

    public void setPosters(Posters posters) {
        this.posters = posters;
    }

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }

    public List<Crews> getCrews() {
        return crews;
    }

    public void setCrews(List<Crews> crews) {
        this.crews = crews;
    }

    public List<Genres> getGenre() {
        return genre;
    }

    public void setGenre(List<Genres> genre) {
        this.genre = genre;
    }

    public List<Studios> getStudio() {
        return studio;
    }

    public void setStudio(List<Studios> studio) {
        this.studio = studio;
    }

    public List<Releases> getRelease() {
        return release;
    }

    public void setRelease(List<Releases> release) {
        this.release = release;
    }

    public List<Themes> getTheme() {
        return theme;
    }

    public void setTheme(List<Themes> theme) {
        this.theme = theme;
    }
}

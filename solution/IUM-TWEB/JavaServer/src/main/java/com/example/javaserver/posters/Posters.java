package com.example.javaserver.posters;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name= "posters")
@IdClass(PostersId.class)
public class Posters {


    @ManyToOne
    //foreign key?
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Movies movies;

    @Id
    @Column(name= "id", nullable= false, columnDefinition= "INTEGER")
    private Long id;
    @Id
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

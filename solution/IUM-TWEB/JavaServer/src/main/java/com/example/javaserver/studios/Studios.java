package com.example.javaserver.studios;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name= "studios")
@IdClass(IdStudios.class)
public class Studios {
    @Id
    @Column(name= "id", nullable= false, columnDefinition= "INTEGER")
    private Long id;
    @Id
    @Column(name= "studio", nullable= false, columnDefinition= "TEXT")
    private String studio;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Movies movie;

    //constructor
    public Studios() {}

    public Studios(Long id, String studio) {
        this.id = id;
        this.studio = studio;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }

}

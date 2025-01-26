package com.example.javaserver.themes;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name= "themes")
@IdClass(IdThemes.class)
public class Themes {
    @Id
    @Column(name= "id", nullable= false, columnDefinition= "INTEGER")
    private Long id;
    @Id
    @Column(name= "theme", nullable= false, columnDefinition= "TEXT")
    private String theme;

    @ManyToOne
    // Collega "id" di ThemesId con la chiave primaria di Movie
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Movies movie; // Relazione molti-a-uno con Movies

    //constructor
    public Themes() {}

    public Themes(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

}

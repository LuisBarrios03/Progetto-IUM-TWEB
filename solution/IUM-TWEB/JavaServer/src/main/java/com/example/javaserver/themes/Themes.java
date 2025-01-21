package com.example.javaserver.themes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name= "themes")
public class Themes {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    //genera un valore Long che si incrementa, lo salvo in identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identity; //????????

    @Column(name= "id", nullable= false, columnDefinition= "INTEGER")
    private Long id;
    @Column(name= "theme", nullable= false, columnDefinition= "TEXT")
    private String theme;

    //constructor
    public Themes() {}

    public Themes(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }


    // Getters and Setters
    public Long getIdentity() {
        return identity;
    }
    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {this.theme = theme;}

}

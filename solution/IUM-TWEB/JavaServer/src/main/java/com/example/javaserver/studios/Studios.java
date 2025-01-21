package com.example.javaserver.studios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name= "studios")
public class Studios {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    //genera un valore Long che si incrementa, lo salvo in identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identity; //????????

    @Column(name= "id", nullable= false, columnDefinition= "INTEGER")
    private Long id;
    @Column(name= "studio", nullable= false, columnDefinition= "TEXT")
    private String studio;

    //constructor
    public Studios() {}

    public Studios(Long id, String studio) {
        this.id = id;
        this.studio = studio;
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

    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }

}

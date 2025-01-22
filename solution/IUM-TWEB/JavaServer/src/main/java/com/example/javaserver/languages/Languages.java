package com.example.javaserver.languages;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name= "languages")
public class Languages {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INTEGER")
    private Long id;
    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private String type;
    @Column(name = "language", nullable = false, columnDefinition = "TEXT")
    private String language;

    //constructor
    public Languages() {
    }

    public Languages(Long id, String type, String language) {
        this.id = id;
        this.type = type;
        this.language = language;
    }

    // Getters and Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getType() {return type;}
    public void setType(String role) {this.type = type;}

    public String getLanguage() {return language;}
    public void setLanguage(String language) {this.language = language;}
}

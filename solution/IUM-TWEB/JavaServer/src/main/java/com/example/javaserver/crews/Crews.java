package com.example.javaserver.crews;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name= "crews")
public class Crews {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    //genera un valore Long che si incrementa, lo salvo in identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role", nullable = false, columnDefinition = "TEXT")
    private String role;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    //constructor
    public Crews() {
    }

    public Crews(Long id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}


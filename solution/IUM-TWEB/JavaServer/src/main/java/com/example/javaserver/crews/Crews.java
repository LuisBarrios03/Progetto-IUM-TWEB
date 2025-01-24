package com.example.javaserver.crews;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name= "crews")
@IdClass(idCrews.class)
public class Crews {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    //genera un valore Long che si incrementa, lo salvo in identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name = "role", nullable = false, columnDefinition = "TEXT")
    private String role;

    @Id
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id")
    private Movies movie;
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


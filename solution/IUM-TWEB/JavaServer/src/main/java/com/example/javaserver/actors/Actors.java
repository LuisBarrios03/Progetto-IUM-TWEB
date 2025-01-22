package com.example.javaserver.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name= "actors")
public class Actors {
    //@ID non esiste sui campi di Java, solo nella conversione al db (indirizzo di memoria, come un indice)
    @Id
    //genera un valore Long che si incrementa, lo salvo in identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long identity; //????????
    //@Column(name= "id", nullable= true, columnDefinition= "INTEGER")
    private Long id;
    @Column(name= "name", nullable= true, columnDefinition= "TEXT")
    private String name;
    @Column(name= "role", nullable= true, columnDefinition= "TEXT")
    private String role;

    //constructor
    public Actors() {}

    public Actors(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Getters and Setters
    /*public Long getIdentity() {
        return identity;
    }
    public void setIdentity(Long identity) {
        this.identity = identity;
    }
*/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}

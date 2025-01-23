package com.example.javaserver.actors;

import jakarta.persistence.*;

@Entity
@Table(name= "actors")
@IdClass(idActors.class)
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column(name= "name", nullable= true, columnDefinition= "TEXT")
    private String name;
    @Id
    @Column(name= "role", nullable= true, columnDefinition= "TEXT")
    private String role;

    //constructor
    public Actors() {}

    public Actors(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
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

package com.example.javaserver.actors;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

/**
 * Entity class representing an actor.
 */
@Entity
@Table(name = "actors")
@IdClass(idActors.class)
public class Actors {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name = "name", nullable = true, columnDefinition = "TEXT")
    private String name;

    @Id
    @Column(name = "role", nullable = true, columnDefinition = "TEXT")
    private String role;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Movies movie;

    /**
     * Default constructor.
     */
    public Actors() {}

    /**
     * Constructs an Actors with the specified id, name, and role.
     *
     * @param id the id of the actor
     * @param name the name of the actor
     * @param role the role of the actor
     */
    public Actors(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    /**
     * Returns the id of the actor.
     *
     * @return the id of the actor
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the actor.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the actor.
     *
     * @return the name of the actor
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the actor.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the role of the actor.
     *
     * @return the role of the actor
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the actor.
     *
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
}
package com.example.javaserver.crews;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

/**
 * Entity class representing a crew.
 */
@Entity
@Table(name = "crews")
@IdClass(idCrews.class)
public class Crews {
    @Id
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

    /**
     * Default constructor.
     */
    public Crews() {
    }

    /**
     * Constructs a Crews with the specified ID, role, and name.
     *
     * @param id the ID of the crew
     * @param role the role of the crew
     * @param name the name of the crew
     */
    public Crews(Long id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
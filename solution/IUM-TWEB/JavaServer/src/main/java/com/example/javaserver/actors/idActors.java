package com.example.javaserver.actors;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

/**
 * Composite key class for Actors entity.
 */
public class idActors implements Serializable {
    private Long id;
    private String name;
    private String role;

    // Getters and setters can be added if needed
}
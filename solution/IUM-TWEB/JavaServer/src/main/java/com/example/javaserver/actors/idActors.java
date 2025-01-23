package com.example.javaserver.actors;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class idActors implements Serializable {
    private Long id;
    private String name;
    private String role;

}

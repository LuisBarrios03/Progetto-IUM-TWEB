package com.example.javaserver.studios;

import java.io.Serializable;

public class IdStudios implements Serializable {
    private Long id; // Chiave esterna che si riferisce a Movies.id
    private String studio; // Nome dello studio
}


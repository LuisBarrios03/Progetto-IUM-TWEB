package com.example.javaserver.releases;

import java.io.Serializable;
import java.util.Date;

public class IdReleases implements Serializable {
    private Long id; // Chiave esterna che si riferisce a Movies.id
    private String country; // paese di rilascio film
    private Date date;
    private String type;
    private String rating;
}
package com.example.javaserver.releases;

import java.io.Serializable;
import java.util.Date;

/**
 * Composite key class for Releases entity.
 */
public class IdReleases implements Serializable {
    private Long id; // Foreign key referring to Movies.id
    private String country; // Country of movie release
    private Date date;
    private String type;
    private String rating;
}
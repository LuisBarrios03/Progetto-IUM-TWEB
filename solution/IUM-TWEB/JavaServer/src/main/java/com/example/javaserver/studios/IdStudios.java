package com.example.javaserver.studios;

import java.io.Serializable;

/**
 * Composite key class for Studios entity.
 */
public class IdStudios implements Serializable {
    /**
     * Foreign key referring to Movies.id.
     */
    private Long id;

    /**
     * Name of the studio.
     */
    private String studio;
}
package com.example.javaserver.posters;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;



public class PostersId implements Serializable {
    private Long id;
    private String link;
}

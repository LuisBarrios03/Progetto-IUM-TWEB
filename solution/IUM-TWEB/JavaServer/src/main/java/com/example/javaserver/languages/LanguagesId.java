package com.example.javaserver.languages;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;



public class LanguagesId implements Serializable {
    private Long id;
    private String language;
    private String type;

//    to-delete
//    public LanguagesId(Long id, String language, String type) {
//        this.id = id;
//        this.language = language;
//        this.type = type;
//    }

}


/*
@Embeddable
public class LanguagesId {
    private Long id;
    private String type;
    private String language;

    public LanguagesId() {} //costruttore

    public LanguagesId(Long id, String type, String language) {
        this.id = id;
        this.type = type;
        this.language = language;
    }



}*/

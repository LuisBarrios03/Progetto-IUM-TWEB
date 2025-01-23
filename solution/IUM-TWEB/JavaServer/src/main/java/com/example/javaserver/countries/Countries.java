package com.example.javaserver.countries;

import com.example.javaserver.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name= "countries")
@IdClass(idCountries.class)
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column(name= "country", nullable= false, columnDefinition= "TEXT")
    private String country;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Movies movie;

    //constructor
    public Countries() {}

    public Countries(Long id, String country) {
        this.id = id;
        this.country = country;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

}



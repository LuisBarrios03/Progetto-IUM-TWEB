package com.example.javaserver.movies;

public class MoviesDTO {

    private Long id;
    private String name;
    private String tagline;
    private String description;
    private Long minute;
    private Double rating;
    private String posterUrl;

    public MoviesDTO(){}

    public MoviesDTO(Long id, String name, String tagline, String description, Long minute, Double rating, String posterUrl) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.description = description;
        this.minute = minute;
        this.rating = (rating != null) ? rating : 0.0; ;
        this.posterUrl = posterUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getMinute() {
        return minute;
    }

    public void setMinute(Long minute) {
        this.minute = minute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


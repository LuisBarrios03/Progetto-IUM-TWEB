package com.example.javaserver.movies;

import java.util.Date;

/**
 * Data Transfer Object for Movies.
 */
public class MoviesDTO {
    private Long id;
    private String name;
    private String tagline;
    private String description;
    private Long minute;
    private Double rating;
    private String posterUrl;
    private Date releaseDate;

    /**
     * Default constructor.
     */
    public MoviesDTO() {}

    /**
     * Constructs a MoviesDTO with the specified parameters.
     *
     * @param id the ID of the movie
     * @param name the name of the movie
     * @param tagline the tagline of the movie
     * @param description the description of the movie
     * @param minute the duration of the movie in minutes
     * @param rating the rating of the movie
     * @param posterUrl the URL of the movie poster
     * @param releaseDate the release date of the movie
     */
    public MoviesDTO(Long id, String name, String tagline, String description, Long minute, Double rating, String posterUrl, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.description = (description != null && !description.isEmpty()) ? description : "No description available";
        this.minute = minute;
        this.rating = (rating != null) ? rating : 0.0;
        this.posterUrl = posterUrl;
        this.releaseDate = releaseDate;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Long getMinute() { return minute; }
    public void setMinute(Long minute) { this.minute = minute; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTagline() { return tagline; }
    public void setTagline(String tagline) { this.tagline = tagline; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }
}
package com.example.javaserver.releases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleasesService {
    private final ReleasesRepository releasesRepository;
    @Autowired
    public ReleasesService(ReleasesRepository releasesRepository) {
        this.releasesRepository = releasesRepository;
    }

    // ritorna tutti i releases
    public List<Releases> getAllReleases() {
        return releasesRepository.findAll();
    }

    public List<Object[]> getReleasesByCountry(String country) {
        return releasesRepository.findReleasesByCountry(country);
    }

    public Long getCountMoviesByCountry(String country) {
        return releasesRepository.countMoviesByCountry(country);
    }

    public List<Object[]> getReleasesByMovieName(String movieName) {
        return releasesRepository.findReleasesByMovieName(movieName);
    }





}

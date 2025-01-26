package com.example.javaserver.crews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewsService {
    private final CrewsRepository crewsRepository;
    @Autowired
    public CrewsService(CrewsRepository crewsRepository) {
        this.crewsRepository = crewsRepository;
    }

    public List<Crews> getAllCrews() {
        return crewsRepository.findAll();
    }

    public List<Crews> getFindByMovieName(String movieName) {
        return crewsRepository.findByMovieNames(movieName);
    }

    public List<Crews> getByid(Long id) {
        return crewsRepository.getById(id);
    }
}

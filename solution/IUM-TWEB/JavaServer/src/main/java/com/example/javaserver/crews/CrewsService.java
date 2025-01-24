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

    public List<Crews> getfindByMovieName(String movieName) {
        return crewsRepository.findByMovieName(movieName);
    }
}

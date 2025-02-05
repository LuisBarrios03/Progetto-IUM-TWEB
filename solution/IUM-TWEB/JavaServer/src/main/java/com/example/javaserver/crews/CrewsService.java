package com.example.javaserver.crews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for managing crews.
 */
@Service
public class CrewsService {
    private final CrewsRepository crewsRepository;

    /**
     * Constructs a CrewsService with the specified CrewsRepository.
     *
     * @param crewsRepository the repository for managing crews
     */
    @Autowired
    public CrewsService(CrewsRepository crewsRepository) {
        this.crewsRepository = crewsRepository;
    }

    /**
     * Retrieves crews by the specified ID.
     *
     * @param id the ID of the crew
     * @return a list of maps containing crew details
     */
    public List<Map<String, Object>> getByid(Long id) {
        List<Object[]> results = crewsRepository.getById(id);
        List<Map<String, Object>> crews = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> crew = new HashMap<>();
            crew.put("name", result[0]);
            crew.put("role", result[1]);
            crews.add(crew);
        }
        return crews;
    }
}
package com.example.javaserver.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing Posters entities.
 */
@Service
public class PostersService {

    private final PostersRepository postersRepository;

    @Autowired
    public PostersService(PostersRepository postersRepository) {
        this.postersRepository = postersRepository;
    }

    /**
     * Retrieves posters by the specified ID.
     *
     * @param id the ID of the poster
     * @return a list of posters with the specified ID
     */
    public List<Posters> getPostersById(Long id) {
        return postersRepository.getPostersById(id);
    }
}
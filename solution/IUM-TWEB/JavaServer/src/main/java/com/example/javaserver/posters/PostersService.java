package com.example.javaserver.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PostersService {
    private final PostersRepository postersRepository;
    @Autowired
    public PostersService(PostersRepository postersRepository) {
        this.postersRepository = postersRepository;
    }

    public List<Posters> getPosters() {
        return postersRepository.getPosters();
    }
}

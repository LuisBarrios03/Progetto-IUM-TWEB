package com.example.javaserver.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

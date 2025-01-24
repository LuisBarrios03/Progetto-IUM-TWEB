package com.example.javaserver.posters;


import com.example.javaserver.actors.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PostersRepository {
    //getAll posters
    @Query("select p from Posters p") List<Posters> getPosters();
}

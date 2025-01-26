package com.example.javaserver.posters;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostersRepository {
    //getAll posters
    @Query("select p from Posters p") List<Posters> getPosters();
}

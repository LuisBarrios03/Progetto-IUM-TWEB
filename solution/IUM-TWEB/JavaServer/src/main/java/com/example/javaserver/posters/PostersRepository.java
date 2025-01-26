package com.example.javaserver.posters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostersRepository extends JpaRepository<Posters, PostersId> {
    //getAll posters
    @Query("select p from Posters p") List<Posters> getPosters();
    //get posters by id
    @Query("select p from Posters p WHERE p.id = :id") List<Posters> getPostersById(Long id);
}

package com.example.javaserver.posters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for managing Posters entities.
 */
@Repository
public interface PostersRepository extends JpaRepository<Posters, PostersId> {

    /**
     * Retrieves posters by the specified ID.
     *
     * @param id the ID of the poster
     * @return a list of posters with the specified ID
     */
    @Query("select p from Posters p WHERE p.id = :id")
    List<Posters> getPostersById(Long id);
}
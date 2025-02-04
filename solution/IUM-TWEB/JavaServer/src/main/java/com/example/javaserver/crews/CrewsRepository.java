package com.example.javaserver.crews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for managing crews.
 */
public interface CrewsRepository extends JpaRepository<Crews, idCrews> {

    /**
     * Retrieves crews by the specified ID.
     *
     * @param id the ID of the crew
     * @return a list of objects containing crew details
     */
    @Query("SELECT c.name, c.role FROM Crews c WHERE c.id = :id")
    List<Object[]> getById(@Param("id") Long id);
}
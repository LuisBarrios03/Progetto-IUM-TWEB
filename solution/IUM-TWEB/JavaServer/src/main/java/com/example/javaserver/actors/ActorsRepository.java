package com.example.javaserver.actors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

// Repositories
@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {
    // Trova tutti gli attori con un determinato ruolo
    @Query(" SELECT a.name" +" FROM Actors a"+" WHERE a.role = :role")
    List<Actors> findActorsByRole(@Param("role") String role);

    // Trova tutti gli attori il cui nome contiene una stringa specifica
    @Query("SELECT a FROM Actors a WHERE a.name LIKE %:name%")
    List<Actors> findActorsByNameContains(@Param("name") String name);
}

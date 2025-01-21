package com.example.javaserver.actors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

// Repositories
@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {
    /*@Query(value= "SELECT a.id, a.name, a.role" + "FROM Actors a" + " WHERE a.identity = :identity " )
    List<String> findByIdentity(Long identity);*/
}

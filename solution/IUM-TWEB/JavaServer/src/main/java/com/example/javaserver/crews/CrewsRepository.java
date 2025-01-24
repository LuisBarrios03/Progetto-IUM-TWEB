package com.example.javaserver.crews;

import com.example.javaserver.movies.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CrewsRepository extends JpaRepository<Crews,idCrews> {

    

}

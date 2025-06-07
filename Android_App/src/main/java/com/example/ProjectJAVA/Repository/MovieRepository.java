package com.example.ProjectJAVA.Repository;

import com.example.ProjectJAVA.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {
    List<Movies> findAll();
}

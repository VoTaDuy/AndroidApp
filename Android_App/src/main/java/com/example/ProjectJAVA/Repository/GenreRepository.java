package com.example.ProjectJAVA.Repository;

import com.example.ProjectJAVA.Entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genres, Integer> {
    List<Genres> findAll();

    Genres findGenresByName(String genre_name);
}

package com.example.ProjectJAVA.Repository;

import com.example.ProjectJAVA.Embeddable.MovieGenreId;
import com.example.ProjectJAVA.Entity.Movie_Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieGenreRepository extends JpaRepository<Movie_Genres, MovieGenreId> {
}

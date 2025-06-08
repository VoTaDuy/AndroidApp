package com.example.ProjectJAVA.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int genre_id;

    @Column(name = "genre_name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "genres")
    private List<Movie_Genres> movieGenresList;

    public List<Movie_Genres> getMovieGenresList() {
        return movieGenresList;
    }

    public void setMovieGenresList(List<Movie_Genres> movieGenresList) {
        this.movieGenresList = movieGenresList;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

//    public String getGenre_name() {
//        return genre_name;
//    }
//
//    public void setGenre_name(String genre_name) {
//        this.genre_name = genre_name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.ProjectJAVA.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;

    @Column(name = "movie_name")
    private String movie_name;

    @Column(name = "movie_description")
    private String movie_description;

    @Column(name = "movie_trailer")
    private String movie_trailer;

    @Column(name = "movie_time")
    private int movie_time;

    @OneToMany(mappedBy = "movies")
    private List<Movie_Genres> movieGenresList;
    public int getMovie_id() {
        return movie_id;
    }

    public List<Movie_Genres> getMovieGenresList() {
        return movieGenresList;
    }

    public void setMovieGenresList(List<Movie_Genres> movieGenresList) {
        this.movieGenresList = movieGenresList;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_description() {
        return movie_description;
    }

    public void setMovie_description(String movie_description) {
        this.movie_description = movie_description;
    }

    public String getMovie_trailer() {
        return movie_trailer;
    }

    public void setMovie_trailer(String movie_trailer) {
        this.movie_trailer = movie_trailer;
    }

    public int getMovie_time() {
        return movie_time;
    }

    public void setMovie_time(int movie_time) {
        this.movie_time = movie_time;
    }
}

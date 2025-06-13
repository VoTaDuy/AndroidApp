package com.example.ProjectJAVA.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @Column(name = "movie_picture")
    private String movie_picture;

    @JsonIgnore
    @OneToMany(mappedBy = "movies")
    private List<Movie_Genres> movieGenresList;

    @OneToMany(mappedBy = "movies")
    @JsonBackReference
    private List<Showtimes> showtimesList;
    @JsonProperty("genres")
    public List<String> getGenreNames() {
        return movieGenresList.stream()
                .map(mg -> mg.getGenres().getName())
                .collect(Collectors.toList());
    }

    public List<Showtimes> getShowtimesList() {
        return showtimesList;
    }

    public void setShowtimesList(List<Showtimes> showtimesList) {
        this.showtimesList = showtimesList;
    }

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

    public String getMovie_picture() {
        return movie_picture;
    }

    public void setMovie_picture(String movie_picture) {
        this.movie_picture = movie_picture;
    }
}

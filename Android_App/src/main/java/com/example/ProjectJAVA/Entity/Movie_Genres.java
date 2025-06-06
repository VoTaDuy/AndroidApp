package com.example.ProjectJAVA.Entity;

import com.example.ProjectJAVA.Embeddable.MovieGenreId;
import jakarta.persistence.*;

@Entity
@Table(name = "movie_genres")
public class Movie_Genres {
    @EmbeddedId
    private MovieGenreId movieGenreId;

    @ManyToOne
    @MapsId("movie_id")
    @JoinColumn(name = "movie_id")
    private Movies movies;

    @ManyToOne
    @MapsId("genre_id")
    @JoinColumn(name = "genre_id")
    private Genres genres;

    public MovieGenreId getMovieGenreId() {
        return movieGenreId;
    }

    public void setMovieGenreId(MovieGenreId movieGenreId) {
        this.movieGenreId = movieGenreId;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }
}

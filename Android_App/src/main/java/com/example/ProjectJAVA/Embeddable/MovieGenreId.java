package com.example.ProjectJAVA.Embeddable;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class MovieGenreId implements Serializable {
    private Integer movie_id;
    private Integer genre_id;


    public MovieGenreId() {}

    public MovieGenreId(Integer movie_id, Integer genre_id) {
        this.movie_id = movie_id;
        this.genre_id = genre_id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieGenreId that = (MovieGenreId) o;
        return Objects.equals(movie_id, that.movie_id) &&
                Objects.equals(genre_id, that.genre_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie_id, genre_id);
    }

}

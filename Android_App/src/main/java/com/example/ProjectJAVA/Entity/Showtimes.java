package com.example.ProjectJAVA.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalTime;

@Entity
@Table(name = "showtimes")
public class Showtimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showtime_id;

    @Column(name = "start_time")
    private LocalTime start_time;

    @Column(name = "end_time")
    private LocalTime end_time;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Rooms room;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "movie_id")
    private Movies movies;


    public int getShowtime_id() {
        return showtime_id;
    }

    public void setShowtime_id(int showtime_id) {
        this.showtime_id = showtime_id;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }
}

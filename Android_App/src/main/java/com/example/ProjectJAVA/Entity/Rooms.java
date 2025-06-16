package com.example.ProjectJAVA.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rooms")
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int room_id;

    @Column(name = "room_name")
    private String room_name;

    @Column(name = "description")
    private String description;

    @Column(name = "capacity")
    private int capacity;


    @OneToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Seats> seatsList;

    @OneToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
    @JsonBackReference

    List<Showtimes> showtimesList;


    public List<Seats> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seats> seatsList) {
        this.seatsList = seatsList;
    }

    public List<Showtimes> getShowtimesList() {
        return showtimesList;
    }

    public void setShowtimesList(List<Showtimes> showtimesList) {
        this.showtimesList = showtimesList;
    }

    public int getRoom_id() {
        return room_id;
    }



    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

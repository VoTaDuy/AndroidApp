package com.example.ProjectJAVA.Entity;

import com.example.ProjectJAVA.Enums.SeatStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "seats")
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;

    @Column(name = "row_seat")
    private char row_seat;


    @OneToMany(mappedBy = "seats", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<BookingSeats> bookingSeatsList;

    @Column(name = "seat_number")
    private int seat_number;

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public char getRow_seat() {
        return row_seat;
    }

    public void setRow_seat(char row_seat) {
        this.row_seat = row_seat;
    }

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Rooms rooms;

    public int getSeatId() {
        return seatId;
    }

    public String getSeatName() {
        return String.format("%c%d", row_seat, seat_number);
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public Rooms getRoom() {
        return rooms;
    }

    public void setRoom(Rooms room) {
        this.rooms = room;
    }
}

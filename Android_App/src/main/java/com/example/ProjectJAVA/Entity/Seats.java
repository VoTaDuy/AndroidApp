package com.example.ProjectJAVA.Entity;

import com.example.ProjectJAVA.Enums.SeatStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seat_id;

    @Column(name = "row_seat")
    private char row_seat;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_status")
    private SeatStatus seat_status = SeatStatus.AVAILABLE ;

    @Column(name = "seat_number")
    private int seat_number;

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public SeatStatus getSeat_status() {
        return seat_status;
    }

    public void setSeat_status(SeatStatus seat_status) {
        this.seat_status = seat_status;
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


    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
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

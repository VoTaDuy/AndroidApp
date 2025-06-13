package com.example.ProjectJAVA.DTO;

import com.example.ProjectJAVA.Entity.Rooms;
import com.example.ProjectJAVA.Enums.SeatStatus;

public class SeatDTO {
    private int seat_id;
    private int seat_number;

    private int room_id;
    private char row_seat;
    private SeatStatus seat_status;


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

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public char getRow_seat() {
        return row_seat;
    }

    public void setRow_seat(char row_seat) {
        this.row_seat = row_seat;
    }

    public SeatStatus getSeat_status() {
        return seat_status;
    }

    public void setSeat_status(SeatStatus seat_status) {
        this.seat_status = seat_status;
    }
}


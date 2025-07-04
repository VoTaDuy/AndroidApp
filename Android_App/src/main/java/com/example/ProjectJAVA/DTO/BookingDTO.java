package com.example.ProjectJAVA.DTO;

import com.example.ProjectJAVA.Enums.BookingStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingDTO {
    private int booking_id;

    private int user_id;

    private int room_id;

    private int showtime_id;

    private int price;

    private LocalDateTime start_time;

    private LocalDateTime end_time;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private BookingStatus booking_status;

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getShowtime_id() {
        return showtime_id;
    }

    public void setShowtime_id(int showtime_id) {
        this.showtime_id = showtime_id;
    }

    public BookingStatus getBooking_status() {
        return booking_status;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public void setBooking_status(BookingStatus booking_status) {
        this.booking_status = booking_status;
    }


}

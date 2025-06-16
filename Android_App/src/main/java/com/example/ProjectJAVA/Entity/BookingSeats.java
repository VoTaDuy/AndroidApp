package com.example.ProjectJAVA.Entity;

import com.example.ProjectJAVA.Enums.SeatStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "booking_seats")
public class BookingSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Bookings bookings;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    @JsonManagedReference
    private Seats seats;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_status")
    private SeatStatus status = SeatStatus.BOOKED;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bookings getBookings() {
        return bookings;
    }

    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}

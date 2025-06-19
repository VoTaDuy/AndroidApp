package com.example.ProjectJAVA.Entity;


import com.example.ProjectJAVA.Enums.BookingStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;


    @Column(name = "price")
    private int price;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private Users users;



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Showtimes getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(Showtimes showtimes) {
        this.showtimes = showtimes;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    @JsonManagedReference
    private Showtimes showtimes;

    @OneToMany(mappedBy = "bookings", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<BookingSeats> bookingSeatsList;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookingStatus bookingStatus = BookingStatus.PENDING;

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<BookingSeats> getBookingSeatsList() {
        return bookingSeatsList;
    }


    public void setBookingSeatsList(List<BookingSeats> bookingSeatsList) {
        this.bookingSeatsList = bookingSeatsList;
    }
}

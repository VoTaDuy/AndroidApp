package com.example.ProjectJAVA.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Bookings bookings;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "status")
    private String status;


    @Column(name = "date_paid")
    private LocalDateTime datepaid;

    public LocalDateTime getDatepaid() {
        return datepaid;
    }

    public void setDatepaid(LocalDateTime datepaid) {
        this.datepaid = datepaid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Bookings getBookings() {
        return bookings;
    }


    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookings = new Bookings();
        this.bookings.setBooking_id(bookingId);
    }


}

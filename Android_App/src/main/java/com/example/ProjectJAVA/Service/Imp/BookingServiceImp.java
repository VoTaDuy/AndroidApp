package com.example.ProjectJAVA.Service.Imp;

import com.example.ProjectJAVA.Entity.Bookings;
import com.example.ProjectJAVA.Payloads.Resquest.BookingRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingServiceImp {

    Bookings createBooking(BookingRequest bookingRequest);
}

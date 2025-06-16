package com.example.ProjectJAVA.Controller;


import com.example.ProjectJAVA.Entity.Bookings;
import com.example.ProjectJAVA.Payloads.Resquest.BookingRequest;
import com.example.ProjectJAVA.Service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@RequestBody @Valid BookingRequest bookingRequest) {
        try {
            System.out.println(bookingRequest.getSeatIds());
            System.out.println(bookingRequest.getShowtimeId());
            System.out.println(bookingRequest.getUserId());
            if (bookingRequest.getUserId() == null || bookingRequest.getShowtimeId() == null || bookingRequest.getSeatIds() == null) {
                return ResponseEntity.badRequest().body("Thiếu thông tin bắt buộc.");
            }

            Bookings booking = bookingService.createBooking(bookingRequest);
            return ResponseEntity.ok(booking); // Hoặc trả DTO nếu muốn đẹp hơn
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/check-booked-seats")
    public ResponseEntity<?> checkBookedSeats(@RequestParam Integer showtimeId,
                                              @RequestBody List<Integer> seatIds) {
        List<Integer> bookedSeatIds = bookingService.getAlreadyBookedSeatIds(showtimeId, seatIds);
        return ResponseEntity.ok(bookedSeatIds);
    }

}

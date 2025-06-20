package com.example.ProjectJAVA.Controller;

import com.example.ProjectJAVA.Entity.Bookings;
import com.example.ProjectJAVA.Entity.Payment;
import com.example.ProjectJAVA.Enums.BookingStatus;
import com.example.ProjectJAVA.Payloads.Resquest.PaymentRequest;
import com.example.ProjectJAVA.Repository.BookingRepository;
import com.example.ProjectJAVA.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/fake")
    public ResponseEntity<String> fakePayment(@RequestBody PaymentRequest request) {
        Bookings booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not exist with ID: " + request.getBookingId()));

        Payment payment = new Payment();
        payment.setBookingId(request.getBookingId());
        payment.setPaymentMethod("FakePay");
        payment.setStatus("SUCCESS");
        payment.setDatepaid(LocalDateTime.now());
        paymentRepository.save(payment);

        booking.setBookingStatus(BookingStatus.BOOKED);
        bookingRepository.save(booking);

        return ResponseEntity.ok("Success");
    }
}

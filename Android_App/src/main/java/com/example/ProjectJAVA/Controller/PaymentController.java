package com.example.ProjectJAVA.Controller;

import com.example.ProjectJAVA.Entity.BookingSeats;
import com.example.ProjectJAVA.Entity.Bookings;
import com.example.ProjectJAVA.Entity.Payment;
import com.example.ProjectJAVA.Enums.BookingStatus;
import com.example.ProjectJAVA.Enums.SeatStatus;
import com.example.ProjectJAVA.Payloads.Response.TicketResponse;
import com.example.ProjectJAVA.Payloads.ResponseData;
import com.example.ProjectJAVA.Payloads.Resquest.PaymentRequest;
import com.example.ProjectJAVA.Repository.BookingRepository;
import com.example.ProjectJAVA.Repository.PaymentRepository;
import com.example.ProjectJAVA.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;



    @PostMapping("/fake")
    public ResponseEntity<?> fakePayment(@RequestBody PaymentRequest request) {

        ResponseData responseData = new ResponseData();

        Bookings booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not exist with ID: " + request.getBookingId()));

        Payment payment = new Payment();
        payment.setBookingId(request.getBookingId());
        payment.setPaymentMethod("FakePay");
        payment.setStatus("SUCCESS");
        payment.setDatepaid(LocalDateTime.now());
        paymentRepository.save(payment);

        booking.setBookingStatus(BookingStatus.BOOKED);
        List<BookingSeats> seats = booking.getBookingSeatsList();
        if (seats != null) {
            for (BookingSeats bs : seats) {
                bs.setStatus(SeatStatus.BOOKED);
            }
        }
        bookingRepository.save(booking);

        List<String> seatNames = booking.getBookingSeatsList().stream()
                .map(bs -> bs.getSeats().getSeatName())
                .toList();

        String ticketCode = "TCK_" + booking.getBooking_id();

        TicketResponse ticket = new TicketResponse();
        ticket.setBookingId(booking.getBooking_id());
        ticket.setUser(booking.getUsers().getUserDetails().getUser());
        ticket.setMovie(booking.getShowtimes().getMovies().getMovie_name());
        ticket.setRoom(booking.getShowtimes().getRooms().getRoom_name());
        ticket.setSeats(seatNames);
        ticket.setShowtime(booking.getShowtimes().getStartTime());
        ticket.setPrice(booking.getPrice());
        ticket.setStatus(booking.getBookingStatus().toString());
        ticket.setTicketCode(ticketCode);

        responseData.setData(ticket);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}

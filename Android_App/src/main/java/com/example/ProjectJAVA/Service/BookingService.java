package com.example.ProjectJAVA.Service;

import com.example.ProjectJAVA.DTO.BookingDTO;
import com.example.ProjectJAVA.Entity.*;
import com.example.ProjectJAVA.Enums.BookingStatus;
import com.example.ProjectJAVA.Enums.SeatStatus;
import com.example.ProjectJAVA.Payloads.Resquest.BookingRequest;
import com.example.ProjectJAVA.Repository.*;
import com.example.ProjectJAVA.Service.Imp.BookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookingService implements BookingServiceImp {

    @Autowired
    SeatRepository seatRepository;
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowtimeRepository showtimeRepository;

    @Autowired
    BookingSeatRepository bookingseatRepository;


    @Override
    public Bookings createBooking(BookingRequest bookingRequest) {
        Users users = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + bookingRequest.getUserId()));

        Showtimes showtimes = showtimeRepository
                .findById(bookingRequest.getShowtimeId()).orElseThrow(() -> new RuntimeException("showtime not found with ID: " + bookingRequest.getShowtimeId() ));

        Rooms rooms = showtimes.getRooms();
        if (bookingseatRepository.isSeatAlreadyBooked(bookingRequest.getSeatIds(), bookingRequest.getShowtimeId())) {
            throw new RuntimeException("Ghế đã có người đặt trước rồi!");
        }
        LocalDateTime startTime = showtimes.getStartTime();
        LocalDateTime endTime = showtimes.getEndTime();

//        long count = bookingRepository.countOverlappingBookingsForUser(bookingRequest.getUserId(), startTime, endTime);
//        if (count > 0) {
//            throw new RuntimeException("User already has a booking that overlaps with this showtime.");
//        }

        Bookings booking = new Bookings();
        booking.setUsers(users);
        booking.setShowtimes(showtimes);
        booking.setBookingStatus(BookingStatus.valueOf("PENDING"));

        Integer price = showtimes.getMovies().getMovie_price();
        booking.setPrice(price != null ? price : 0);
        List<BookingSeats> seatList = new ArrayList<>();
        for (Integer seatId : bookingRequest.getSeatIds()) {
            BookingSeats seat = new BookingSeats();
            seat.setStatus(SeatStatus.valueOf("PENDING"));
            seat.setBookings(booking);
            Seats seatEntity = seatRepository.findById(seatId)
                    .orElseThrow(() -> new RuntimeException("Seat not found with id: " + seatId));
            seat.setSeats(seatEntity);

            seatList.add(seat);
        }

        booking.setBookingSeatsList(seatList);

        Integer pricePerSeat = showtimes.getMovies().getMovie_price();
        int totalPrice = pricePerSeat != null ? pricePerSeat * bookingRequest.getSeatIds().size() : 0;
        booking.setPrice(totalPrice);


        return bookingRepository.save(booking);

    }

    @Override
    public List<BookingDTO> getBookingByUserId(Integer userId) {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        List<Bookings> bookings = bookingRepository.findAllByUsers(users);
        List<BookingDTO> bookingDTOList = new ArrayList<>();
        for (Bookings booking : bookings) {
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setBooking_id(booking.getBooking_id());
            bookingDTO.setUser_id(booking.getUsers().getUserId());
            bookingDTO.setBooking_status(booking.getBookingStatus());
            bookingDTO.setPrice(booking.getPrice());
            bookingDTO.setShowtime_id(booking.getShowtimes().getShowtimeId());
            bookingDTO.setRoom_id(booking.getShowtimes().getRooms().getRoom_id());

            bookingDTOList.add(bookingDTO);
        }

        return bookingDTOList;

    }

    public List<Integer> getAlreadyBookedSeatIds(Integer showtimeId, List<Integer> seatIds) {
            return bookingRepository.findBookedSeatIdsForShowtime(showtimeId, seatIds);
    }

}

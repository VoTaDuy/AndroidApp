package com.example.ProjectJAVA.Repository;

import com.example.ProjectJAVA.Entity.BookingSeats;
import com.example.ProjectJAVA.Entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingSeatRepository  extends JpaRepository<BookingSeats, Integer> {

    @Query("SELECT COUNT(bs) > 0 FROM BookingSeats bs " +
            "WHERE bs.seats.id IN :seatIds " +
            "AND bs.bookings.showtimes.id = :showtimeId " +
            "AND bs.bookings.bookingStatus = 'BOOKED'")
    boolean isSeatAlreadyBooked(@Param("seatIds") List<Integer> seatIds,
                                @Param("showtimeId") Integer showtimeId);


}

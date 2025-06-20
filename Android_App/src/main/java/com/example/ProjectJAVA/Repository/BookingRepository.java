package com.example.ProjectJAVA.Repository;


import com.example.ProjectJAVA.Entity.Bookings;
import com.example.ProjectJAVA.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Integer> {

    @Query("SELECT bs.seats.id FROM BookingSeats bs " +
            "WHERE bs.bookings.showtimes.id = :showtimeId AND bs.seats.id IN :seatIds")
    List<Integer> findBookedSeatIdsForShowtime(@Param("showtimeId") Integer showtimeId,
                                               @Param("seatIds") List<Integer> seatIds);



    @Query("SELECT COUNT(b) FROM Bookings b " +
            "WHERE b.users.userId = :userId " +
            "AND b.bookingStatus != 'CANCELLED' " +
            "AND ((b.showtimes.startTime BETWEEN :startTime AND :endTime) " +
            "OR (b.showtimes.endTime BETWEEN :startTime AND :endTime) " +
            "OR (b.showtimes.startTime <= :startTime AND b.showtimes.endTime >= :endTime))")
    Long countOverlappingBookingsForUser(@Param("userId") Integer userId,
                                         @Param("startTime") LocalDateTime startTime,
                                         @Param("endTime") LocalDateTime endTime);


    List<Bookings> findAllByUsers(Users users);


}

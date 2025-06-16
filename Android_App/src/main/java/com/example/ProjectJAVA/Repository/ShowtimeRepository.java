package com.example.ProjectJAVA.Repository;

import com.example.ProjectJAVA.Entity.Showtimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtimes, Integer> {

    @Query("SELECT COUNT(s) FROM Showtimes s WHERE " +
            "((s.startTime BETWEEN :startTime AND :endTime) OR " +
            "(s.endTime BETWEEN :startTime AND :endTime) OR " +
            "(s.startTime <= :startTime AND s.endTime >= :endTime))")
    Long countOverlappingBookings(@Param("startTime") LocalDateTime startTime,
                                  @Param("endTime") LocalDateTime endTime);


}

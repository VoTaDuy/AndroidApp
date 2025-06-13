package com.example.ProjectJAVA.Repository;

import com.example.ProjectJAVA.Entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seats, Integer> {
}

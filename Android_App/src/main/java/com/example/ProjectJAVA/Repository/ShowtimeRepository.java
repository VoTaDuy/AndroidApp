package com.example.ProjectJAVA.Repository;

import com.example.ProjectJAVA.Entity.Showtimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtimes, Integer> {
}

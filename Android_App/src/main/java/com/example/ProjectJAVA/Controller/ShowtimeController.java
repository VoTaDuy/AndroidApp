package com.example.ProjectJAVA.Controller;

import com.example.ProjectJAVA.Repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showtime")
public class ShowtimeController {

    @Autowired
    ShowtimeRepository showtimeRepository;

    @GetMapping("/get")
    public ResponseEntity<?> getShowtimeList(){

        return new ResponseEntity<>(showtimeRepository.findAll(), HttpStatus.OK);
    }

}

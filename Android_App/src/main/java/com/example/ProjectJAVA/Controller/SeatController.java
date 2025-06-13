package com.example.ProjectJAVA.Controller;

import com.example.ProjectJAVA.Service.Imp.SeatServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatServiceImp seatServiceImp;

    @GetMapping("/get")
    public ResponseEntity<?> getSeatList(){
        return new ResponseEntity<>(seatServiceImp.getSeatList(), HttpStatus.OK);
    }
}

package com.example.ProjectJAVA.Controller;

import com.example.ProjectJAVA.Service.Imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomServiceImp roomServiceImp;

    @GetMapping("/get")
    public ResponseEntity <?> getRoomList(){

        return new ResponseEntity<>(roomServiceImp.roomList(), HttpStatus.OK);
    }
}

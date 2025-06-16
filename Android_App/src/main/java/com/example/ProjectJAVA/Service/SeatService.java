package com.example.ProjectJAVA.Service;

import com.example.ProjectJAVA.DTO.SeatDTO;
import com.example.ProjectJAVA.Entity.Seats;
import com.example.ProjectJAVA.Repository.SeatRepository;
import com.example.ProjectJAVA.Service.Imp.SeatServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService implements SeatServiceImp {

    @Autowired
    SeatRepository seatRepository;

    @Override
    public List<SeatDTO> getSeatList() {
        List<Seats> seatsList = seatRepository.findAll();
        List<SeatDTO> seatDTOList = new ArrayList<>();
        for (Seats seats : seatsList){
            SeatDTO seatDTO = new SeatDTO();
            seatDTO.setSeat_id(seats.getSeatId());
            seatDTO.setSeat_number(seats.getSeat_number());
            seatDTO.setRow_seat(seats.getRow_seat());
            seatDTO.setRoom_id(seats.getRooms().getRoom_id());
            seatDTOList.add(seatDTO);
        }
        return seatDTOList;
    }
}

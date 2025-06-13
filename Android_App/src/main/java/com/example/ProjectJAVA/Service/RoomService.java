package com.example.ProjectJAVA.Service;

import com.example.ProjectJAVA.DTO.RoomDTO;
import com.example.ProjectJAVA.Entity.Rooms;
import com.example.ProjectJAVA.Repository.RoomRepository;
import com.example.ProjectJAVA.Service.Imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RoomService implements RoomServiceImp {


    @Autowired
    RoomRepository roomRepository;


    @Override
    public List<RoomDTO> roomList() {
        List<Rooms> roomList = roomRepository.findAll();
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for (Rooms rooms : roomList){
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRoom_id(rooms.getRoom_id());
            roomDTO.setDescription(rooms.getDescription());
            roomDTO.setCapacity(rooms.getCapacity());
            roomDTOList.add(roomDTO);
        }
        return roomDTOList;
    }
}

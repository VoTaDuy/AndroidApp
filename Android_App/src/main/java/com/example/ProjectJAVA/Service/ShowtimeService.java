package com.example.ProjectJAVA.Service;

import com.example.ProjectJAVA.DTO.ShowtimeDTO;
import com.example.ProjectJAVA.Entity.Showtimes;
import com.example.ProjectJAVA.Repository.ShowtimeRepository;
import com.example.ProjectJAVA.Service.Imp.ShowtimeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowtimeService implements ShowtimeServiceImp {

    @Autowired
    ShowtimeRepository showtimeRepository;

    @Override
    public List<ShowtimeDTO> getShowtimeList() {
        List<Showtimes> showtimesList = showtimeRepository.findAll();
        List<ShowtimeDTO> showtimeDTOList = new ArrayList<>();
        for (Showtimes showtimes : showtimesList){
            ShowtimeDTO showtimeDTO = new ShowtimeDTO();
            showtimeDTO.setShowtime_id(showtimes.getShowtime_id());
            showtimeDTO.setMovie_id(showtimes.getMovies().getMovie_id());
            showtimeDTO.setRoom_id(showtimes.getRoom().getRoom_id());
            showtimeDTO.setStart_time(showtimes.getStart_time());
            showtimeDTO.setEnd_time(showtimes.getEnd_time());
            showtimeDTOList.add(showtimeDTO);
        }
        return showtimeDTOList;
    }
}

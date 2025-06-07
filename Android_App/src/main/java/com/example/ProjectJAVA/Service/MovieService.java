package com.example.ProjectJAVA.Service;


import com.example.ProjectJAVA.DTO.MovieDTO;
import com.example.ProjectJAVA.Entity.Movies;
import com.example.ProjectJAVA.Repository.MovieRepository;
import com.example.ProjectJAVA.Service.Imp.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements MovieServiceImp
{
    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<MovieDTO> getMovieList() {

        List<Movies> moviesList = movieRepository.findAll();
        List<MovieDTO> movieDTOList = new ArrayList<>();

        for (Movies movies : moviesList) {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setMovie_id(movies.getMovie_id());
            movieDTO.setMovie_name(movies.getMovie_name());
            movieDTO.setMovie_description(movies.getMovie_description());
            movieDTO.setMovie_picture(movies.getMovie_picture());
            movieDTO.setMovie_trailer(movies.getMovie_trailer());
            movieDTO.setMovie_time(movies.getMovie_time());
            movieDTOList.add(movieDTO);
        }

        return movieDTOList;

    }
}

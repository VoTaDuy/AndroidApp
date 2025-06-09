package com.example.ProjectJAVA.Service.Imp;


import com.example.ProjectJAVA.DTO.MovieDTO;
import com.example.ProjectJAVA.Entity.Movies;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieServiceImp {
    public List<MovieDTO> getMovieList();

    public boolean checkMovieExist(int movie_id);

    public Movies getMovieById(int movie_id);

    public boolean checkMovieCreate(MultipartFile file,
                                    String movie_name,
                                    String movie_description,
                                    String movie_trailer,
                                    int movie_time);
}

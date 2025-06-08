package com.example.ProjectJAVA.Service.Imp;


import com.example.ProjectJAVA.DTO.MovieDTO;
import com.example.ProjectJAVA.Entity.Movies;

import java.util.List;

public interface MovieServiceImp {
    public List<MovieDTO> getMovieList();

    public boolean checkMovieExist(int movie_id);

    public Movies getMovieById(int movie_id);
}

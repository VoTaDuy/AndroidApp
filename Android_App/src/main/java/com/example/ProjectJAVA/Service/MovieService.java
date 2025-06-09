package com.example.ProjectJAVA.Service;


import com.example.ProjectJAVA.DTO.MovieDTO;
import com.example.ProjectJAVA.Entity.Movies;
import com.example.ProjectJAVA.Repository.MovieRepository;
import com.example.ProjectJAVA.Service.Imp.FileServiceImp;
import com.example.ProjectJAVA.Service.Imp.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements MovieServiceImp
{
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    FileServiceImp fileServiceImp;

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

    @Override
    public boolean checkMovieExist(int movie_id) {
        Movies movies=  movieRepository.findById(movie_id)
                .orElseThrow(() -> new RuntimeException("Can not find this Id: " + movie_id));
        if (movies == null) return false;
        else return true;
    }

    @Override
    public Movies getMovieById(int movie_id) {
        Movies movies = movieRepository.findById(movie_id).
                orElseThrow(() -> new RuntimeException("Can not found with ID: " + movie_id));
        if (checkMovieExist(movie_id)){
            return movies;
        }else {
            System.out.println("error");
            return null;
        }


    }

    @Override
    public boolean checkMovieCreate(MultipartFile file,
                                    String movie_name,
                                    String movie_description,
                                    String movie_trailer,
                                    int movie_time) {

        boolean isInsertSuccess = false;

        try {
            boolean isSavedFileSuccess = fileServiceImp.saveFile(file);
            if (isSavedFileSuccess){
                Movies movies = new Movies();
                movies.setMovie_name(movie_name);
                movies.setMovie_description(movie_description);
                movies.setMovie_trailer(movie_trailer);
                movies.setMovie_time(movie_time);
                movies.setMovie_picture(file.getOriginalFilename());
                movieRepository.save(movies);
                isInsertSuccess = true;
            }
        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
            return false;
        }

        return isInsertSuccess;

    }
}

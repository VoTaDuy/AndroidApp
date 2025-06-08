package com.example.ProjectJAVA.Controller;


import com.example.ProjectJAVA.Entity.Movies;
import com.example.ProjectJAVA.Payloads.ResponseData;
import com.example.ProjectJAVA.Payloads.Resquest.GenreRequest;
import com.example.ProjectJAVA.Service.Imp.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServiceImp movieServiceImp;

    @GetMapping("/get")
    public ResponseEntity<?> getMovieList(){

        return new ResponseEntity<>(movieServiceImp.getMovieList(), HttpStatus.OK);
    }

    @GetMapping("/get/{movie_id}")
    public ResponseEntity<?> getMovieById(@PathVariable int movie_id){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieServiceImp.getMovieById(movie_id));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createGenre(@RequestBody GenreRequest genreRequest){

        return null;

    }
    }

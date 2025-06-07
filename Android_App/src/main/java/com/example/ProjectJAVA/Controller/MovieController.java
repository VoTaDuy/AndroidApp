package com.example.ProjectJAVA.Controller;


import com.example.ProjectJAVA.Service.Imp.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServiceImp movieServiceImp;

    @GetMapping("/get")
    public ResponseEntity<?> getMovieList(){

        return new ResponseEntity<>(movieServiceImp.getMovieList(), HttpStatus.OK);
    }

}

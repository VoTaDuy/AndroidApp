package com.example.ProjectJAVA.Controller;

import com.example.ProjectJAVA.Payloads.ResponseData;
import com.example.ProjectJAVA.Service.Imp.GenreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreServiceImp genreServiceImp;
    @GetMapping("/get")
    public ResponseEntity<?> getAllGenre(){
        return new ResponseEntity<>(genreServiceImp.getGenreList(), HttpStatus.OK);
    }
}

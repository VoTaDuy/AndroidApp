package com.example.ProjectJAVA.Controller;

import com.example.ProjectJAVA.Entity.Genres;
import com.example.ProjectJAVA.Payloads.ResponseData;
import com.example.ProjectJAVA.Payloads.Resquest.GenreRequest;
import com.example.ProjectJAVA.Service.Imp.GenreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreServiceImp genreServiceImp;
    @GetMapping("/get")
    public ResponseEntity<?> getAllGenre(){
        return new ResponseEntity<>(genreServiceImp.getGenreList(), HttpStatus.OK);
    }

    @GetMapping("/get/{Id}")
    public ResponseEntity<?> getGenreByGenre_Id(@PathVariable int Id){
        ResponseData responseData = new ResponseData();
        responseData.setData(genreServiceImp.getGenreById(Id));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createGenre(@RequestBody GenreRequest genreRequest){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = genreServiceImp.isCreateGenre(genreRequest);
        if (isSuccess){
            responseData.setSuccess(true);
            responseData.setData("insert completed");
        }else {
            responseData.setSuccess(false);
            responseData.setData("failed");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}

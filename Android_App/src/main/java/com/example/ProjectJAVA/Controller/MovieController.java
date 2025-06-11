package com.example.ProjectJAVA.Controller;


import com.example.ProjectJAVA.Payloads.ResponseData;
import com.example.ProjectJAVA.Service.Imp.FileServiceImp;
import com.example.ProjectJAVA.Service.Imp.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServiceImp movieServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

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
    public ResponseEntity<?> createMovie(@RequestParam MultipartFile file,
                                         @RequestParam String movie_name,
                                         @RequestParam String movie_description,
                                         @RequestParam String movie_trailer,
                                         @RequestParam int movie_time){
        System.out.println("hello");
        ResponseData responseData = new ResponseData();
        System.out.println(file.getOriginalFilename());
        System.out.println(movie_name);
        System.out.println(movie_description);
        System.out.println(movie_trailer);
        System.out.println(movie_time);

        boolean isSuccess = movieServiceImp.checkMovieCreate(file,movie_name,movie_description,movie_trailer,movie_time);

        System.out.println(isSuccess);
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> GetFileProduct(@PathVariable String filename) {
        Resource resource = fileServiceImp.loadFile(filename);

        // Kiểm tra null
        if (resource == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("File not exist: " + filename);
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                        + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("{movie_id}/genre/{genre_id}")
    public ResponseEntity<?> getMovieByGenreId(@PathVariable Integer movie_id, @PathVariable Integer genre_id){
        ResponseData responseData = new ResponseData();
        movieServiceImp.addGenreToMovie(movie_id,genre_id);
        responseData.setData("add genre to movie success");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


    }

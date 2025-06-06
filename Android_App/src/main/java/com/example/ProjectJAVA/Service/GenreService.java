package com.example.ProjectJAVA.Service;


import com.example.ProjectJAVA.DTO.GenreDTO;
import com.example.ProjectJAVA.Entity.Genres;
import com.example.ProjectJAVA.Repository.GenreRepository;
import com.example.ProjectJAVA.Service.Imp.GenreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService implements GenreServiceImp {

    @Autowired
    GenreRepository genreRepository;


    @Override
    public List<GenreDTO> getGenreList() {
        List<Genres> genresList = genreRepository.findAll();
        List<GenreDTO> genreDTOList = new ArrayList<>();
        for (Genres genres : genresList){
            GenreDTO genreDTO = new GenreDTO();
            genreDTO.setGenre_id(genres.getGenre_id());
            genreDTO.setGenre_name(genres.getGenre_name());
            genreDTO.setDescription(genres.getDescription());
            genreDTOList.add(genreDTO);
        }
        return genreDTOList;
    }
}

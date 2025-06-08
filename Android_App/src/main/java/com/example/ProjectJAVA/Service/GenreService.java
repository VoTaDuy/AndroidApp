package com.example.ProjectJAVA.Service;


import com.example.ProjectJAVA.DTO.GenreDTO;
import com.example.ProjectJAVA.Entity.Genres;
import com.example.ProjectJAVA.Payloads.Resquest.GenreRequest;
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
            genreDTO.setGenre_name(genres.getName());
            genreDTO.setDescription(genres.getDescription());
            genreDTOList.add(genreDTO);
        }
        return genreDTOList;
    }

    @Override
    public Genres getGenreById(int genre_id) {
        Genres genres = genreRepository.findById(genre_id)
                .orElseThrow(() -> new RuntimeException("Genre not found with ID: " + genre_id ));
        if (checkGenreExist(genre_id)){
            return genres;
        } else{
            System.out.println("error");
            return null;
        }
    }

    @Override
    public boolean checkGenreExist(int genre_id) {
        Genres genres = genreRepository.findById(genre_id)
                .orElseThrow(() -> new RuntimeException("Genre not found with ID: " + genre_id ));;
        if (genres == null) {
            return false;
        }else return true;
    }

    @Override
    public Boolean isCreateGenre(GenreRequest genreRequest) {
        if (genreRepository.findGenresByName(genreRequest.getGenre_name()) != null){
            System.out.println("Genre already exist");
            return false;
        }

        Genres genres = new Genres();
        genres.setName(genreRequest.getGenre_name());
        genres.setDescription(genreRequest.getDescription());

        try {
            System.out.println("Inserting Genre");
            genreRepository.save(genres);
            System.out.println("Inserted Genre");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }
}

package com.example.ProjectJAVA.Service.Imp;

import com.example.ProjectJAVA.DTO.GenreDTO;
import com.example.ProjectJAVA.Entity.Genres;
import com.example.ProjectJAVA.Payloads.Resquest.GenreRequest;

import java.util.List;

public interface GenreServiceImp {
    List<GenreDTO> getGenreList();
    Genres getGenreById(int genre_id);

    boolean checkGenreExist(int genre_id);

    Boolean isCreateGenre(GenreRequest genreRequest);
}

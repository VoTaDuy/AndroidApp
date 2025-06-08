package com.example.ProjectJAVA.Service.Imp;

import com.example.ProjectJAVA.DTO.GenreDTO;
import com.example.ProjectJAVA.Entity.Genres;
import com.example.ProjectJAVA.Payloads.Resquest.GenreRequest;

import java.util.List;

public interface GenreServiceImp {
    public List<GenreDTO> getGenreList();
    public Genres getGenreById(int genre_id);

    public boolean checkGenreExist(int genre_id);

    public Boolean isCreateGenre(GenreRequest genreRequest);
}

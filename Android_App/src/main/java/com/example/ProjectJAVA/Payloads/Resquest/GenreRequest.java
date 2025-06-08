package com.example.ProjectJAVA.Payloads.Resquest;

public class GenreRequest {
    private  String genre_name;

    private String description;

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.ProjectJAVA.DTO;

public class GenreDTO {
    private int genre_id;
    private String genre_name;
    private String description;

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

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

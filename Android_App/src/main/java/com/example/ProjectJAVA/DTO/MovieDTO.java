package com.example.ProjectJAVA.DTO;

public class MovieDTO {
    private int movie_id;
    private String movie_name;

    private String movie_description;

    private String movie_picture;

    private String movie_trailer;

    private int movie_time;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_description() {
        return movie_description;
    }

    public void setMovie_description(String movie_description) {
        this.movie_description = movie_description;
    }

    public String getMovie_picture() {
        return movie_picture;
    }

    public void setMovie_picture(String movie_picture) {
        this.movie_picture = movie_picture;
    }

    public String getMovie_trailer() {
        return movie_trailer;
    }

    public void setMovie_trailer(String movie_trailer) {
        this.movie_trailer = movie_trailer;
    }

    public int getMovie_time() {
        return movie_time;
    }

    public void setMovie_time(int movie_time) {
        this.movie_time = movie_time;
    }
}

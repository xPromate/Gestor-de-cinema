package com.estg.mtsds.moviediscovery.entity;

import com.estg.mtsds.moviediscovery.model.CinemaRoom;
import org.springframework.data.annotation.Id;

public class Movie {

    @Id
    private String id;
    private String movieId;
    private String movieName;
    private String exhibitionDate;
    private String exhibitionHour;
    private CinemaRoom cinemaRoom;
    private boolean isFull;

    public Movie() {
    }

    public Movie(String movieId, String movieName, String exhibitionDate, String exhibitionHour, CinemaRoom cinemaRoom) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.exhibitionHour = exhibitionHour;
        this.cinemaRoom = cinemaRoom;
        this.isFull = false;
        this.exhibitionDate = exhibitionDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getExhibitionHour() {
        return exhibitionHour;
    }

    public void setExhibitionHour(String exhibitionHour) {
        this.exhibitionHour = exhibitionHour;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public String getExhibitionDate() {
        return exhibitionDate;
    }

    public void setExhibitionDate(String exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", exhibitionDate='" + exhibitionDate + '\'' +
                ", exhibitionHour='" + exhibitionHour + '\'' +
                ", cinemaRoom=" + cinemaRoom +
                ", isFull=" + isFull +
                '}';
    }
}

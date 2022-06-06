package com.estg.mtsds.moviemanager.model;

public class Movie {


    private String id;
    private String movieName;
    private String exhibitionDate;
    private String exhibitionHour;
    private CinemaRoom cinemaRoom;
    private boolean isFull;

    public Movie() {
    }

    public Movie(String movieName, String exhibitionDate, String exhibitionHour, CinemaRoom cinemaRoom) {
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

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", movieName='" + movieName + '\'' +
                ", exhibitionDate='" + exhibitionDate + '\'' +
                ", exhibitionHour='" + exhibitionHour + '\'' +
                ", cinemaRoom=" + cinemaRoom +
                ", isFull=" + isFull +
                '}';
    }
}

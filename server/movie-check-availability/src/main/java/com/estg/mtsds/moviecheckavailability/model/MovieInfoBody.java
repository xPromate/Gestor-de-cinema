package com.estg.mtsds.moviecheckavailability.model;

public class MovieInfoBody {

    private String movieName;
    private String exhibitionDate;
    private String exhibitionHour;
    private int[] x;
    private int[] y;

    public MovieInfoBody(String movieName, String exhibitionDate, String exhibitionHour, int[] x, int[] y) {
        this.movieName = movieName;
        this.exhibitionDate = exhibitionDate;
        this.exhibitionHour = exhibitionHour;
        this.x = x;
        this.y = y;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getExhibitionDate() {
        return exhibitionDate;
    }

    public void setExhibitionDate(String exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public String getExhibitionHour() {
        return exhibitionHour;
    }

    public void setExhibitionHour(String exhibitionHour) {
        this.exhibitionHour = exhibitionHour;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }
}

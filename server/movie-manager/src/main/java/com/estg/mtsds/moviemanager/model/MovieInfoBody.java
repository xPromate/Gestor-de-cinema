package com.estg.mtsds.moviemanager.model;

import java.util.Arrays;

public class MovieInfoBody {

    private String eventId;
    private int[] x;
    private int[] y;

    public MovieInfoBody(String eventId, int[] x, int[] y) {
        this.eventId = eventId;
        this.x = x;
        this.y = y;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    @Override
    public String toString() {
        return "MovieInfoBody{" +
                "eventId='" + eventId + '\'' +
                ", x=" + Arrays.toString(x) +
                ", y=" + Arrays.toString(y) +
                '}';
    }
}

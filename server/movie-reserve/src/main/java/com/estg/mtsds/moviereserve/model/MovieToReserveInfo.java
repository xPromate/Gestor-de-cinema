package com.estg.mtsds.moviereserve.model;

import java.util.Arrays;

public class MovieToReserveInfo {

    private String reservationId;
    private String eventId;
    private int[] x;
    private int[] y;

    public MovieToReserveInfo(String reservationId, String eventId, int[] x, int[] y) {
        this.reservationId = reservationId;
        this.eventId = eventId;
        this.x = x;
        this.y = y;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
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
        return "MovieToReserveInfo{" +
                "reservationId='" + reservationId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", x=" + Arrays.toString(x) +
                ", y=" + Arrays.toString(y) +
                '}';
    }
}

package com.estg.mtsds.moviecheckavailability.model;

public class Seat {

    private boolean isOccupied;
    private String reservationId;

    public Seat() {
        this.isOccupied = false;
        this.reservationId = "";
    }

    public Seat(String reservationId) {
        this.isOccupied = false;
        this.reservationId = reservationId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "isOccupied=" + isOccupied +
                ", reservationId='" + reservationId + '\'' +
                '}';
    }
}

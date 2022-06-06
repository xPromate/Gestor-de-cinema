package com.estg.mtsds.cronjobreserve.models;

public class Seat {

    private boolean isOccupied;
    private String reservationId;
    private boolean paid;
    private String dateTime;

    public Seat() {
        this.isOccupied = false;
        this.reservationId = "";
        this.paid = false;
        this.dateTime = "";
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "isOccupied=" + isOccupied +
                ", reservationId='" + reservationId + '\'' +
                ", paid=" + paid +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}

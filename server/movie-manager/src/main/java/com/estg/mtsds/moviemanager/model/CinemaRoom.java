package com.estg.mtsds.moviemanager.model;

public class CinemaRoom {

    private String roomName;
    private Seat[][] seats;

    public CinemaRoom(String roomName) {
        this.roomName = roomName;
        this.seats = new Seat[8][6];
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }
}

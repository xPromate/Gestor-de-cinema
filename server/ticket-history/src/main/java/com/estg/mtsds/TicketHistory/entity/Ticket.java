package com.estg.mtsds.TicketHistory.entity;

import java.util.Arrays;

import com.estg.mtsds.TicketHistory.model.Seat;
import org.springframework.data.annotation.Id;

public class Ticket {

    @Id
    private String reservationId;
    private int numberOfSeats;
    private String roomName;
    private Seat[] localSeats;
    private String movieName;
    private String dateTime;


    public Ticket(int numberOfSeats, String roomName, Seat[] localSeats, String movieName, String dateTime, String reservationId) {
        this.numberOfSeats = numberOfSeats;
        this.roomName = roomName;
        this.localSeats = localSeats;
        this.movieName = movieName;
        this.dateTime = dateTime;
        this.reservationId = reservationId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Seat[] getLocalSeats() {
        return localSeats;
    }

    public void setLocalSeats(Seat[] localSeats) {
        this.localSeats = localSeats;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "numberOfSeats=" + numberOfSeats +
                ", roomName='" + roomName + '\'' +
                ", localSeats=" + Arrays.toString(localSeats) +
                ", movieName='" + movieName + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", reservationId='" + reservationId + '\'' +
                '}';
    }

}

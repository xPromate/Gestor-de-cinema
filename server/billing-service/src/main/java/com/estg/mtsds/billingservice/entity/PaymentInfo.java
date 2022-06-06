package com.estg.mtsds.billingservice.entity;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class PaymentInfo {

    @Id
    private String reserveId;
    private int userId;
    private int nif;
    private float value;
    private int numberOfTickets;
    private String eventId;
    private String movieName;
    private String movieId;

    public PaymentInfo(){

    }

    public PaymentInfo(int userId, int nif, float value, int numberOfTickets, String eventId, String movieName, String movieId, String reserveId) {
        this.userId = userId;
        this.nif = nif;
        this.value = value;
        this.numberOfTickets = numberOfTickets;
        this.eventId = eventId;
        this.movieName = movieName;
        this.movieId = movieId;
        this.reserveId = reserveId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "userId=" + userId +
                ", nif=" + nif +
                ", value=" + value +
                ", numberOfTickets=" + numberOfTickets +
                ", eventId='" + eventId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieId='" + movieId + '\'' +
                ", reserveId='" + reserveId + '\'' +
                '}';
    }
}
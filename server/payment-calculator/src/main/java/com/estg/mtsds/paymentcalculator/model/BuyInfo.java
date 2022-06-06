package com.estg.mtsds.paymentcalculator.model;

public class BuyInfo {

    private int numberOfTickets;
    private String movieId;
    private String reserveId;
    private int nachos;
    private int popcorn;
    private int cocaCola;
    private int iceTeaLemon;
    private int sprite;
    private int water;

    public BuyInfo(int numberOfTickets, String movieId, String reserveId, int nachos, int popcorn, int cocaCola, int iceTeaLemon, int sprite, int water) {
        this.numberOfTickets = numberOfTickets;
        this.movieId = movieId;
        this.reserveId = reserveId;
        this.nachos = nachos;
        this.popcorn = popcorn;
        this.cocaCola = cocaCola;
        this.iceTeaLemon = iceTeaLemon;
        this.sprite = sprite;
        this.water = water;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
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

    public int getNachos() {
        return nachos;
    }

    public void setNachos(int nachos) {
        this.nachos = nachos;
    }

    public int getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(int popcorn) {
        this.popcorn = popcorn;
    }

    public int getCocaCola() {
        return cocaCola;
    }

    public void setCocaCola(int cocaCola) {
        this.cocaCola = cocaCola;
    }

    public int getIceTeaLemon() {
        return iceTeaLemon;
    }

    public void setIceTeaLemon(int iceTeaLemon) {
        this.iceTeaLemon = iceTeaLemon;
    }

    public int getSprite() {
        return sprite;
    }

    public void setSprite(int sprite) {
        this.sprite = sprite;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    @Override
    public String toString() {
        return "BuyInfo{" +
                "numberOfTickets=" + numberOfTickets +
                ", movieId='" + movieId + '\'' +
                ", reserveId='" + reserveId + '\'' +
                ", nachos=" + nachos +
                ", popcorn=" + popcorn +
                ", cocaCola=" + cocaCola +
                ", iceTeaLemon=" + iceTeaLemon +
                ", sprite=" + sprite +
                ", water=" + water +
                '}';
    }
}
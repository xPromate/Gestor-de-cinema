package com.estg.mtsds.paymentcalculator.entity;

import org.springframework.data.annotation.Id;


public class MoviePrice {

    @Id
    private String id;
    private float ticketPrice;
    private float nachosPrice;
    private float popcornPrice;
    private float cocaColaPrice;
    private float lemonIceTeaPrice;
    private float spritePrice;
    private float waterPrice;

    public MoviePrice(String id, float ticketPrice, float nachosPrice, float popcornPrice, float cocaColaPrice, float lemonIceTeaPrice, float spritePrice, float waterPrice) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.nachosPrice = nachosPrice;
        this.popcornPrice = popcornPrice;
        this.cocaColaPrice = cocaColaPrice;
        this.lemonIceTeaPrice = lemonIceTeaPrice;
        this.spritePrice = spritePrice;
        this.waterPrice = waterPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public float getNachosPrice() {
        return nachosPrice;
    }

    public void setNachosPrice(float nachosPrice) {
        this.nachosPrice = nachosPrice;
    }

    public float getPopcornPrice() {
        return popcornPrice;
    }

    public void setPopcornPrice(float popcornPrice) {
        this.popcornPrice = popcornPrice;
    }

    public float getCocaColaPrice() {
        return cocaColaPrice;
    }

    public void setCocaColaPrice(float cocaColaPrice) {
        this.cocaColaPrice = cocaColaPrice;
    }

    public float getLemonIceTeaPrice() {
        return lemonIceTeaPrice;
    }

    public void setLemonIceTeaPrice(float lemonIceTeaPrice) {
        this.lemonIceTeaPrice = lemonIceTeaPrice;
    }

    public float getSpritePrice() {
        return spritePrice;
    }

    public void setSpritePrice(float spritePrice) {
        this.spritePrice = spritePrice;
    }

    public float getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(float waterPrice) {
        this.waterPrice = waterPrice;
    }

    @Override
    public String toString() {
        return "MoviePrice{" +
                "id='" + id + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", nachosPrice=" + nachosPrice +
                ", popcornPrice=" + popcornPrice +
                ", cocaColaPrice=" + cocaColaPrice +
                ", lemonIceTeaPrice=" + lemonIceTeaPrice +
                ", spritePrice=" + spritePrice +
                ", waterPrice=" + waterPrice +
                '}';
    }
}

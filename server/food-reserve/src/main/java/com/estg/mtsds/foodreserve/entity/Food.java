package com.estg.mtsds.foodreserve.entity;

import org.springframework.data.annotation.Id;

public class Food {

    @Id
    private String id;
    private float nachosKg;
    private float popcornKg;
    private float cocaColaLiters;
    private float lemonIceTeaLiters;
    private float spriteLiters;
    private float waterLiters;

    public Food(String id, float nachosKg, float popcornKg, float cocaColaLiters, float lemonIceTeaLiters, float spriteLiters, float waterLiters) {
        this.id = id;
        this.nachosKg = nachosKg;
        this.popcornKg = popcornKg;
        this.cocaColaLiters = cocaColaLiters;
        this.lemonIceTeaLiters = lemonIceTeaLiters;
        this.spriteLiters = spriteLiters;
        this.waterLiters = waterLiters;
    }

    public float getNachosKg() {
        return nachosKg;
    }

    public void setNachosKg(float nachosKg) {
        this.nachosKg = nachosKg;
    }

    public void setPopcornKg(float popcornKg) {
        this.popcornKg = popcornKg;
    }

    public float getWaterLiters() {
        return waterLiters;
    }

    public void setWaterLiters(float waterLiters) {
        this.waterLiters = waterLiters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getCocaColaLiters() {
        return cocaColaLiters;
    }

    public void setCocaColaLiters(float cocaColaLiters) {
        this.cocaColaLiters = cocaColaLiters;
    }

    public float getLemonIceTeaLiters() {
        return lemonIceTeaLiters;
    }

    public void setLemonIceTeaLiters(float lemonIceTeaLiters) {
        this.lemonIceTeaLiters = lemonIceTeaLiters;
    }

    public float getSpriteLiters() {
        return spriteLiters;
    }

    public void setSpriteLiters(float spriteLiters) {
        this.spriteLiters = spriteLiters;
    }

    public float getPopcornKg() {
        return popcornKg;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id='" + id + '\'' +
                ", nachosKg=" + nachosKg +
                ", popcornKg=" + popcornKg +
                ", cocaColaLiters=" + cocaColaLiters +
                ", lemonIceTeaLiters=" + lemonIceTeaLiters +
                ", spriteLiters=" + spriteLiters +
                ", waterLiters=" + waterLiters +
                '}';
    }
}

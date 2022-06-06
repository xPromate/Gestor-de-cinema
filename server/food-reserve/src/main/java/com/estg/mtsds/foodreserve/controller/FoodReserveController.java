package com.estg.mtsds.foodreserve.controller;

import com.estg.mtsds.foodreserve.entity.Food;
import com.estg.mtsds.foodreserve.model.FoodInfo;
import com.estg.mtsds.foodreserve.service.FoodReserveService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodReserveController {

    @Autowired
    private FoodReserveService foodReserveService;

    @RabbitListener(queues = "food-reservation-queue")
    public void makeFoodReservation(String message) {

        Gson g = new Gson();
        FoodInfo foodInfo = g.fromJson(message, FoodInfo.class);
        List<Food> food = this.foodReserveService.getFood();
        Food f = food.get(0);

        float nachosKg = f.getNachosKg() - foodInfo.getNachosKg();
        float popcornKg = f.getPopcornKg() - foodInfo.getPopcornKg();
        float cocaColaLiters = f.getCocaColaLiters() - foodInfo.getCocaColaLiters();
        float lemonIceTeaLiters = f.getLemonIceTeaLiters() - foodInfo.getLemonIceTeaLiters();
        float spriteLiters = f.getSpriteLiters() - foodInfo.getSpriteLiters();
        float waterLiters = f.getWaterLiters() - foodInfo.getWaterLiters();

        Food foodToSave = new Food(f.getId(), nachosKg, popcornKg, cocaColaLiters, lemonIceTeaLiters, spriteLiters, waterLiters);

        this.foodReserveService.saveFoodReservation(foodToSave);
    }
}

package com.estg.mtsds.foodavailability.controller;

import com.estg.mtsds.foodavailability.entity.Food;
import com.estg.mtsds.foodavailability.model.FoodInfo;
import com.estg.mtsds.foodavailability.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/checkFoodAvailability")
public class FoodAvailabilityController {

    @Autowired
    private FoodService foodService;

    //metodo teste para apagar depois
    @PostMapping("/create")
    public Food createFood(@RequestBody Food food) {
        this.foodService.saveFood(food);

        return food;
    }

    @CrossOrigin
    @PostMapping("/availability")
    public HashMap<String, Boolean> checkFoodAvailability(@RequestBody FoodInfo foodInfo) {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        List<Food> foodList = this.foodService.getFoodInStock();
        System.out.println("pedido recebido");


        if (foodList.get(0).getNachosKg() >= foodInfo.getNachosKg() && foodList.get(0).getPopcornKg() >= foodInfo.getPopcornKg() &&
                foodList.get(0).getCocaColaLiters() >= foodInfo.getCocaColaLiters() && foodList.get(0).getLemonIceTeaLiters() >= foodInfo.getLemonIceTeaLiters() &&
                foodList.get(0).getSpriteLiters() >= foodInfo.getSpriteLiters() && foodList.get(0).getWaterLiters() >= foodInfo.getWaterLiters()) {
            hashMap.put("available", true);
        } else {
            hashMap.put("available", false);
        }

        return hashMap;
    }
}

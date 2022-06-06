package com.estg.mtsds.foodavailability.service;

import com.estg.mtsds.foodavailability.entity.Food;
import com.estg.mtsds.foodavailability.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    //metodo teste
    public Food saveFood(Food food) {
        return this.foodRepository.save(food);
    }

    public List<Food> getFoodInStock() {
        return this.foodRepository.findAll();
    }
}

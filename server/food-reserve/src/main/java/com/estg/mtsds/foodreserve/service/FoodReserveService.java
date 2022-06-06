package com.estg.mtsds.foodreserve.service;

import com.estg.mtsds.foodreserve.entity.Food;
import com.estg.mtsds.foodreserve.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodReserveService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getFood() {
        return this.foodRepository.findAll();
    }

    public Food saveFoodReservation(Food food) {
        return this.foodRepository.save(food);
    }
}

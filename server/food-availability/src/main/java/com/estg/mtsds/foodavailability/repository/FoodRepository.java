package com.estg.mtsds.foodavailability.repository;

import com.estg.mtsds.foodavailability.entity.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {
}

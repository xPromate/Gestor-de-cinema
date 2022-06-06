package com.estg.mtsds.foodreserve.repository;

import com.estg.mtsds.foodreserve.entity.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {

}

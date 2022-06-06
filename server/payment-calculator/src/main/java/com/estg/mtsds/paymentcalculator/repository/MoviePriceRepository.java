package com.estg.mtsds.paymentcalculator.repository;

import com.estg.mtsds.paymentcalculator.entity.MoviePrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoviePriceRepository extends MongoRepository<MoviePrice,String> {
    MoviePrice findMoviePriceById(String id);
}

package com.estg.mtsds.paymentcalculator.service;

import com.estg.mtsds.paymentcalculator.entity.MoviePrice;
import com.estg.mtsds.paymentcalculator.repository.MoviePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class MoviePriceService {

    @Autowired
    private MoviePriceRepository moviePriceRepository;

    public MoviePrice findMoviePriceBymovieId(String id){
        return moviePriceRepository.findMoviePriceById(id);
    }

    public MoviePrice saveMoviePrice(MoviePrice moviePrice){
        return moviePriceRepository.save(moviePrice);
    }
}

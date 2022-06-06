package com.estg.mtsds.paymentcalculator.controller;

import com.estg.mtsds.paymentcalculator.entity.MoviePrice;
import com.estg.mtsds.paymentcalculator.model.BuyInfo;
import com.estg.mtsds.paymentcalculator.service.MoviePriceService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/moviePrices")
public class MoviePriceController {

    @Autowired
    private MoviePriceService moviePriceService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/create")
    public MoviePrice saveMoviePrice() {

        MoviePrice moviePrice = new MoviePrice("4", 3.5f, 3f, 3f, 1.5f, 1.5f, 1.5f, 1.5f);

        return this.moviePriceService.saveMoviePrice(moviePrice);

    }

    @CrossOrigin
    @PostMapping("/calculatePrice")
    public HashMap<String, Float> calculatePrice(@RequestBody BuyInfo buyInfo) throws InterruptedException {
        HashMap<String, Float> hashMap = new HashMap<>();
        System.out.println(buyInfo.toString());

        MoviePrice moviePrice = moviePriceService.findMoviePriceBymovieId(buyInfo.getMovieId());

        float priceTickets = buyInfo.getNumberOfTickets() * moviePrice.getTicketPrice();
        float nachosPrice = buyInfo.getNachos() * moviePrice.getNachosPrice();
        float popcornPrice = buyInfo.getPopcorn() * moviePrice.getPopcornPrice();
        float cocaColaPrice = buyInfo.getCocaCola() * moviePrice.getCocaColaPrice();
        float lemonIceTeaPrice = buyInfo.getIceTeaLemon() * moviePrice.getLemonIceTeaPrice();
        float spritePrice = buyInfo.getSprite() * moviePrice.getLemonIceTeaPrice();
        float waterPrice = buyInfo.getWater() * moviePrice.getWaterPrice();
        float price = priceTickets + nachosPrice + popcornPrice + cocaColaPrice + lemonIceTeaPrice + spritePrice + waterPrice;

        hashMap.put("price", price);

        return hashMap;
    }


}

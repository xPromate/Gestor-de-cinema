package com.estg.mtsds.foodmanager.controller;

import com.estg.mtsds.foodmanager.model.FoodInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodManager")
public class FoodManagerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @CrossOrigin
    @PostMapping("/makeFoodReservation")
    public void makeFoodReservation(@RequestBody FoodInfo foodInfo) {

        try {
            ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();
            String json = ow.writeValueAsString(foodInfo);

            this.rabbitTemplate.convertAndSend("directExchange", "food-reservation-key", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

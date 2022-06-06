package com.estg.mtsds.moviemanager.controller;

import com.estg.mtsds.moviemanager.model.Movie;
import com.estg.mtsds.moviemanager.model.MovieInfoBody;
import com.estg.mtsds.moviemanager.model.MovieToReserveInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @CrossOrigin
    @PostMapping("/makeReserve")
    public MovieToReserveInfo checkMovieAvailability(@RequestBody MovieInfoBody movieInfoBody) {

        try {
            String uuid = UUID.randomUUID().toString() ;
            System.out.println(uuid);
            MovieToReserveInfo movieToReserveInfo = new MovieToReserveInfo(uuid, movieInfoBody.getEventId(), movieInfoBody.getX(), movieInfoBody.getY());
            ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();
            String json = ow.writeValueAsString(movieToReserveInfo);

            this.rabbitTemplate.convertAndSend("directExchange", "movie-reservation-key", json);
            return movieToReserveInfo;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.estg.mtsds.moviemanager.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Queue movieReservationQueue(){
        return new Queue("movie-reservation-queue");
    }

    @Bean
    public Exchange sampleExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding movieReservationBinding(Queue movieReservationQueue, DirectExchange directExchange){
        return BindingBuilder.bind(movieReservationQueue).to(directExchange).with("movie-reservation-key");
    }
}

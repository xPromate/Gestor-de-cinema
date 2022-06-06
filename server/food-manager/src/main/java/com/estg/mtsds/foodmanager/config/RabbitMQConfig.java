package com.estg.mtsds.foodmanager.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue foodReservationQueue() {
        return new Queue("food-reservation-queue");
    }

    @Bean
    public Exchange sampleExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding foodReservationBinding(Queue foodReservationQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(foodReservationQueue).to(directExchange).with("food-reservation-key");
    }

}

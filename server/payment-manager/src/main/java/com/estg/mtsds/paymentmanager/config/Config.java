package com.estg.mtsds.paymentmanager.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean
    public Queue billingQueue(){
        return new Queue("billing-queue");
    }

    @Bean
    public Exchange sampleExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding billingBinding(Queue billingQueue, DirectExchange directExchange){
        return BindingBuilder.bind(billingQueue).to(directExchange).with("billing-key");
    }
}
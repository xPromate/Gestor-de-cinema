package com.estg.mtsds.TakeTicket.Config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean
    public Queue taketicketQueue(){
        return new Queue("taketicket-queue");
    }

    @Bean
    public Exchange sampleExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding billingBinding(Queue taketicketQueue, DirectExchange directExchange){
        return BindingBuilder.bind(taketicketQueue).to(directExchange).with("taketicket-key");
    }
}

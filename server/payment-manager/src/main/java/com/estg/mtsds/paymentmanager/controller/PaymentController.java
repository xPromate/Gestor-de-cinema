package com.estg.mtsds.paymentmanager.controller;

import com.estg.mtsds.paymentmanager.model.PaymentInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @CrossOrigin
    @PostMapping("/makePayment")
    public void makePayment(@RequestBody PaymentInfo paymentInfo){
        System.out.println(paymentInfo.toString());

        try {
            ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();
            String json = ow.writeValueAsString(paymentInfo);
            System.out.println(json);

            this.rabbitTemplate.convertAndSend("directExchange", "billing-key", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }





}

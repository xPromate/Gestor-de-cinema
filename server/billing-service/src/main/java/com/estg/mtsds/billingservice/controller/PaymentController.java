package com.estg.mtsds.billingservice.controller;

import com.estg.mtsds.billingservice.entity.PaymentInfo;
import com.estg.mtsds.billingservice.service.PaymentInfoService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {


    @Autowired
    private PaymentInfoService paymentInfoService;


    @RabbitListener(queues = "billing-queue")
    public void reservationDetails(String message) {

        System.out.println(message);

        Gson g = new Gson();

        PaymentInfo paymentInfo = g.fromJson(message,PaymentInfo.class);

        paymentInfoService.savePayment(paymentInfo);

        System.out.println(paymentInfo.toString());
    }

}

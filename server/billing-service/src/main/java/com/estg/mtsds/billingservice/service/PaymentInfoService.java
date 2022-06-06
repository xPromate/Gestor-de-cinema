package com.estg.mtsds.billingservice.service;

import com.estg.mtsds.billingservice.entity.PaymentInfo;
import com.estg.mtsds.billingservice.repository.PaymentInfoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoService {

    @Autowired
    private PaymentInfoRepositoryJPA paymentInfoRepositoryJPA;

    public PaymentInfo savePayment(PaymentInfo paymentInfo){
        return paymentInfoRepositoryJPA.save(paymentInfo);
    }

}

package com.estg.mtsds.billinghistoryservice.service;

import com.estg.mtsds.billinghistoryservice.entity.PaymentInfo;
import com.estg.mtsds.billinghistoryservice.repository.PaymentInfoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentInfoService {

    @Autowired
    private PaymentInfoRepositoryJPA paymentInfoRepositoryJPA;

    public List<PaymentInfo> listPayments(){
        return paymentInfoRepositoryJPA.findAll();
    }

}

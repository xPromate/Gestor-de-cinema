package com.estg.mtsds.billinghistoryservice.repository;


import com.estg.mtsds.billinghistoryservice.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentInfoRepositoryJPA extends JpaRepository<PaymentInfo, String> {
}


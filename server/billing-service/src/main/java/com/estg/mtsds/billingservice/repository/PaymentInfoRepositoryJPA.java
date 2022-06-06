package com.estg.mtsds.billingservice.repository;

import com.estg.mtsds.billingservice.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentInfoRepositoryJPA extends JpaRepository<PaymentInfo, String> {
}

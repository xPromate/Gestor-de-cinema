package com.estg.mtsds.paymentcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentCalculatorApplication.class, args);
	}

}

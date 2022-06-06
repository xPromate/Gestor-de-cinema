package com.estg.mtsds.billinghistoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BillingHistoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingHistoryServiceApplication.class, args);
	}

}

package com.estg.mtsds.foodavailability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FoodAvailabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAvailabilityApplication.class, args);
	}

}

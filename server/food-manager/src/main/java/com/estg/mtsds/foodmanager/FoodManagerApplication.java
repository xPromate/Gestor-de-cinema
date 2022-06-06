package com.estg.mtsds.foodmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FoodManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodManagerApplication.class, args);
	}

}

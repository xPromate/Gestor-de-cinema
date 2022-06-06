package com.estg.mtsds.moviecheckavailability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MovieCheckAvailabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCheckAvailabilityApplication.class, args);
	}

}

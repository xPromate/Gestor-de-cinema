package com.estg.mtsds.TicketHistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TicketHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketHistoryApplication.class, args);
	}

}

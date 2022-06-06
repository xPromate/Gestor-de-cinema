package com.estg.mtsds.cronjobreserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CronjobReserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(CronjobReserveApplication.class, args);
	}

}

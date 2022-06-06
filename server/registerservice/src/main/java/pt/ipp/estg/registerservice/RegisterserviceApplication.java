package pt.ipp.estg.registerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RegisterserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterserviceApplication.class, args);
	}

}

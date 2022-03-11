package br.edu.infnet.bemseguro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BemseguroApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BemseguroApiApplication.class, args);
	}

}

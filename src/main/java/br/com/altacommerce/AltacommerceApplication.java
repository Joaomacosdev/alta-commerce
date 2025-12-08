package br.com.altacommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AltacommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AltacommerceApplication.class, args);
	}

}

package br.com.altacommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AltacommerceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AltacommerceApplication.class, args);
	}




}

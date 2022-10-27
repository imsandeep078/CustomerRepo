package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication /* (exclude = {DataSourceAutoConfiguration.class}) */
public class CustomerWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerWebAppApplication.class, args);
	}

}

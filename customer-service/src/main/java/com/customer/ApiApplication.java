package com.customer;

import org.service.customer.dto.CustomerRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.customer.repositories.CustomerRepository;
import com.customer.services.CustomerService;

@SpringBootApplication
public class ApiApplication {

	@Autowired
	CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService) {
		return args -> {
			customerService.save(new CustomerRequestDTO("C1", "hatim", "hatim@gmail.com"));
		};
	}
}

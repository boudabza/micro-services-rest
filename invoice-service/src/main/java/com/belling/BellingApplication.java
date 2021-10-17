package com.belling;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.belling.dto.InvoiceRequestDto;
import com.belling.services.InvoiceService;

@SpringBootApplication
@EnableFeignClients
public class BellingApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(BellingApplication.class, args);
	}

	@Bean
	CommandLineRunner start(InvoiceService invoiceService) {
		return args -> {
			invoiceService.save(new InvoiceRequestDto(new BigDecimal(15000), "C1"));
		};
	}
}

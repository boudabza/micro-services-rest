package com.belling.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belling.dto.InvoiceRequestDto;
import com.belling.dto.InvoiceResponseDto;
import com.belling.services.InvoiceService;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestAPI {
	
	@Autowired
	private InvoiceService invoiceService;

	@GetMapping(path = "/invoices")
	public List<InvoiceResponseDto> invoices() {
		return invoiceService.getInvoices();
	}

	@GetMapping(path = "/invoices/{id}")
	public InvoiceResponseDto invoice(@PathVariable String id) {
		return invoiceService.getInvoice(id);
	}

	@GetMapping(path = "/invoicesByCustomer/{customerId}")
	public List<InvoiceResponseDto> getInvoiceByCustomer(@PathVariable String customerId) {
		return invoiceService.getInvoicesByCustomerId(customerId);
	}

	@PostMapping(path = "/invoices")
	public InvoiceResponseDto save(@RequestBody InvoiceRequestDto invoiceRequestDTO) {
		return invoiceService.save(invoiceRequestDTO);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

package com.customer.web;

import java.util.List;
import java.util.UUID;

import org.service.customer.dto.CustomerRequestDTO;
import org.service.customer.dto.CustomerResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.services.CustomerService;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestController {

	private CustomerService customerService;

	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}

    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDTO customerById(@PathVariable String id){
        return customerService.getCustomer(id);
    }
    
	@GetMapping(path = "/customers")
	public List<CustomerResponseDTO> customers() {
		return customerService.getCustomers();
	}

	@PostMapping(path = "/customers")
	public CustomerResponseDTO  save(@RequestBody CustomerRequestDTO  customerRequestDTO) {
		customerRequestDTO.setId(UUID.randomUUID().toString());
		return customerService.save(customerRequestDTO);
	}
}

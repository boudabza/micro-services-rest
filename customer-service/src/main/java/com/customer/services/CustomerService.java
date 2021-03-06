package com.customer.services;

import java.util.List;

import org.service.customer.dto.CustomerRequestDTO;
import org.service.customer.dto.CustomerResponseDTO;


public interface CustomerService {

    List<CustomerResponseDTO> getCustomers();
    CustomerResponseDTO save(CustomerRequestDTO customer);
	CustomerResponseDTO getCustomer(String id);

}

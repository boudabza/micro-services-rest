package com.customer.hatim;

import org.mapstruct.Mapper;
import org.service.customer.dto.CustomerRequestDTO;
import org.service.customer.dto.CustomerResponseDTO;

import com.customer.entities.Customer;

// Utiliser spring pour injecter cette interface
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerDTO(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDTO customerRequestDTO);
}

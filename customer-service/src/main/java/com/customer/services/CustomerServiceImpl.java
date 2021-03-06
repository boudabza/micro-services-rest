package com.customer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.service.customer.dto.CustomerRequestDTO;
import org.service.customer.dto.CustomerResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entities.Customer;
import com.customer.hatim.CustomerMapper;
import com.customer.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
		Customer savedCustomer = customerRepository.save(customer);
		return customerMapper.customerToCustomerDTO(savedCustomer);
	}

    @Override
    public List<CustomerResponseDTO> getCustomers() {
        List<Customer> customers=customerRepository.findAll();
        return customers.stream().map((customer)->customerMapper.customerToCustomerDTO(customer)).collect(Collectors.toList());
    }
    
    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer=customerRepository.findById(id).get();
        return customerMapper.customerToCustomerDTO(customer);
    }
}

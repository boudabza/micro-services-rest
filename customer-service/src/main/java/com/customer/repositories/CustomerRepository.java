package com.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.entities.Customer;


//Interface spring data 
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}

package com.belling.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belling.entites.Invoice;
import java.lang.String;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	List<Invoice> findByCustomerID(String customerid);
}

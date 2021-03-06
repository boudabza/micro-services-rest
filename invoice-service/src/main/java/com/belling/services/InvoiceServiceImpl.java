package com.belling.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belling.dto.InvoiceRequestDto;
import com.belling.dto.InvoiceResponseDto;
import com.belling.entites.Customer;
import com.belling.entites.Invoice;
import com.belling.exception.CustomerNotFoundExcetpion;
import com.belling.mappers.InvoiceMapper;
import com.belling.openfeign.CustomerServiceRestClient;
import com.belling.repositories.InvoiceRepository;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	InvoiceMapper invoiceMapper;
	
	@Autowired
	CustomerServiceRestClient customerRestClient;
	
	@Override
	public List<InvoiceResponseDto> getInvoices() {
        List<Invoice> invoices=invoiceRepository.findAll();
        for(Invoice invoice:invoices){
            Customer customer=customerRestClient.customerById(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map((inv)->invoiceMapper.invoiceToInvoiceDTO(inv)).collect(Collectors.toList());
	}

	@Override
	public InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto) {
		
        Customer customer;
        try {
            customer=customerRestClient.customerById(invoiceRequestDto.getCustomerID());
        } catch (Exception e){
         throw new CustomerNotFoundExcetpion(e.getMessage());
        }
		Invoice invoice = invoiceMapper.invoiceRequestDtoToInvoice(invoiceRequestDto);
		invoice.setDate(new Date());
		invoice.setId(UUID.randomUUID().toString());
		Invoice savedInvoice = invoiceRepository.save(invoice);
		invoice.setCustomer(customer);
		return invoiceMapper.invoiceToInvoiceDTO(savedInvoice);
	}

	@Override
	public InvoiceResponseDto getInvoice(String invoiceId) {
		Invoice invoice = invoiceRepository.findById(invoiceId).orElseGet(null);
		Customer customer = customerRestClient.customerById(invoice.getCustomerID());
		invoice.setCustomer(customer);
		return invoiceMapper.invoiceToInvoiceDTO(invoice);
	}

	@Override
	public List<InvoiceResponseDto> getInvoicesByCustomerId(String customerId) {
		
		List<Invoice> invoices = invoiceRepository.findByCustomerID(customerId);
		return invoices
				.stream()
				.map((inv) -> invoiceMapper.invoiceToInvoiceDTO(inv))
				.collect(Collectors.toList());

	}

}

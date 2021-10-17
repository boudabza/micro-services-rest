package com.belling.services;

import java.util.List;

import com.belling.dto.InvoiceRequestDto;
import com.belling.dto.InvoiceResponseDto;

public interface InvoiceService {

	List<InvoiceResponseDto> getInvoices();

	InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto);

	InvoiceResponseDto getInvoice(String id);
	
	List<InvoiceResponseDto> getInvoicesByCustomerId(String customerId);

}

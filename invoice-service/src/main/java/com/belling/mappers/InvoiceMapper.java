package com.belling.mappers;

import org.mapstruct.Mapper;

import com.belling.dto.InvoiceRequestDto;
import com.belling.dto.InvoiceResponseDto;
import com.belling.entites.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
	InvoiceResponseDto invoiceToInvoiceDTO(Invoice invoice);

	Invoice invoiceRequestDtoToInvoice(InvoiceRequestDto invoiceRequestDTO);
}

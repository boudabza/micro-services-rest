package com.belling.dto;

import java.math.BigDecimal;

public class InvoiceRequestDto {

	private BigDecimal amount;
	private String customerID;

	
	public InvoiceRequestDto(BigDecimal amount, String customerID) {
		this.amount = amount;
		this.customerID = customerID;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}

package com.belling.dto;

import java.math.BigDecimal;
import java.util.Date;


import com.belling.entites.Customer;

public class InvoiceResponseDto {

	private String id;
	private Date date;
	private BigDecimal amount;
	private Customer customer;

	
	public InvoiceResponseDto() {
	}

	public InvoiceResponseDto(String id, Date date, BigDecimal amount, Customer customer) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.customer = customer;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}

package com.belling.entites;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Invoice {

	@Id
	private String id;
	private Date date;
	private BigDecimal amount;

	// une facture liée a un client on doit garder juste l'id client puique ce n'est
	// pas de même service
	private String customerID;

	@Transient // ce n'est persistence (entity) JPA devrait l'ignoré c'est juste pour stocké
				// les donné vient d'un autre service
	private Customer customer;

	
	public Invoice() {
	}

	public Invoice(String id, Date date, BigDecimal amount, String customerID, Customer customer) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.customerID = customerID;
		this.customer = customer;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}

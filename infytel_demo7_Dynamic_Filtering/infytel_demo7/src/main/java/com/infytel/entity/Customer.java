package com.infytel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Entity class that should be passed around for DB related operations
@Entity 
public class Customer 
{
	//Annotation that helps marking a field as the primary key
	@Id 
	//Annotation that helps bridging the difference in the names between the entity and the persistence area
	@Column(name="customer_id")
	private int customerId;
	@Column(name="customer_email")
	private String customerEmail;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="customer_password")
	private String customerPassword;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
}

package com.infytel.dto;






import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
//Annotation that helps filtering data dynamically here
@JsonFilter(value="CustomerFilter")
//Data Transfer Object that carries data from one layer to another
public class CustomerDTO 
{
	
	private int customerId;
	
	private String customerEmail;
	private String customerName;
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

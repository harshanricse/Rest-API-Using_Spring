package com.infytel.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

//Data Transfer Object that carries data from one layer to another
//Annotation that is required to serialize data in XML format
@XmlRootElement
public class CustomerDTO 
{
	private int customerId;
	private String customerEmail;
	private String customerName;
	
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

	
}

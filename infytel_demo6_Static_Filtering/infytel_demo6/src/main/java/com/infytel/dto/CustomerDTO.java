package com.infytel.dto;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

//Data Transfer Object that carries data from one layer to another
@XmlRootElement
//value field will carry any no of fields that are delimited by commas
@JsonIgnoreProperties(value={"customerPassword"},allowSetters=true)
//@XmlAccessorType(value=XmlAccessType.FIELD)
public class CustomerDTO 
{
	
	private int customerId;
	
	private String customerEmail;
	private String customerName;
	//@JsonIgnore
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
	@XmlTransient
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
}

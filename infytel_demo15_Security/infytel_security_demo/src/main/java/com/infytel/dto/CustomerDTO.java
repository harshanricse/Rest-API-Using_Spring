package com.infytel.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.xml.bind.annotation.XmlRootElement;
//Data Transfer Object that carries data from one layer to another
@JsonIgnoreProperties(value= {"customerPassword"}, allowSetters=true)
@XmlRootElement
public class CustomerDTO 
{	
	private int customerId;
	
	@NotNull(message="{customer.phone.must}")
	private Long customerPhoneNo;
	
	@NotNull(message="{customer.email.must}")
	@Email(message= "{customer.email.invalid}")
	private String customerEmail;
	
	@NotBlank(message="{customer.name.must}")
	private String customerName;
	
	//Password should comprise of alphabets of both the cases and digits as well with a length of minimum 5
	@NotEmpty(message="{customer.password.must}")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$",message= "{customer.password.invalid}")
	private String customerPassword;
	
	@Min(value=18, message = "{customer.age.invalid}")
	@Max(value=60, message = "{customer.age.invalid}")
	private int customerAge;
	
	
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
	public Long getcustomerPhoneNo() {
		return customerPhoneNo;
	}
	public void setcustomerPhoneNo(Long customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
}

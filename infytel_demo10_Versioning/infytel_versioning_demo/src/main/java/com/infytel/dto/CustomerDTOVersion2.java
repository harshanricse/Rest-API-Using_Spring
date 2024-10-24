package com.infytel.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.xml.bind.annotation.XmlTransient;

//Data Transfer Object that carries data from one layer to another
@JsonIgnoreProperties(value= {"customerPassword"}, allowSetters=true)
//@XmlRootElement
public class CustomerDTOVersion2 
{	
	private int customerId;
	@NotNull(message="{customer.phone.must}")
	private Long phoneNo;
	@NotNull(message="{customer.email.must}")
	@Email(message= "{customer.email.invalid}")
	private String customerEmail;
	@NotBlank(message="{customer.name.must}")
	@JsonProperty("firstName")
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String lastName;
	//Password should comprise of alphabets of both the cases and digits as well with a length of minimum 5
	@NotEmpty(message="{customer.password.must}")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$",message= "{customer.password.invalid}")
	private String customerPassword;
	@Min(value=18, message = "{customer.age.invalid}")
	@Max(value=60, message = "{customer.age.invalid}")
	private int age;
	
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
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@XmlTransient
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

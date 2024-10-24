package com.infytel.dto;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Data Transfer Object that carries data from one layer to another
//@JsonIgnoreProperties(value= {"customerPassword"}, allowSetters=true)
//@XmlRootElement
public class CustomerDTO 
{	
	private int customerId;
	
	private Long phoneNo;
	
	private String customerEmail;
	
	private String customerName;
	
	private String customerPassword;
	
	private int customerAge;
	
	private PlanDTO planDTO;
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
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public PlanDTO getPlanDTO() {
		return planDTO;
	}
	public void setPlanDTO(PlanDTO planDTO) {
		this.planDTO = planDTO;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", phoneNo=" + phoneNo + ", customerEmail=" + customerEmail
				+ ", customerName=" + customerName + ", customerPassword=" + customerPassword + ", customerAge="
				+ customerAge + ", planDTO=" + planDTO + "]";
	}
}

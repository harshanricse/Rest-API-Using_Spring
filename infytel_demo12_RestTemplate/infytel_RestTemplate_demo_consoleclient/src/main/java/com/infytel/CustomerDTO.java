package com.infytel;




//Data Transfer Object that carries data from one layer to another
//@JsonIgnoreProperties(value= {"customerPassword"}, allowSetters=true)
public class CustomerDTO 
{	
	private int customerId;
	
	private Long phoneNo;
	
	private String customerEmail;
	
	private String customerName;
	
	//Password should comprise of alphabets of both the cases and digits as well with a length of minimum 5
	private String customerPassword;
	
	private int customerAge;
	
	private PlanDTO planDTO;
	
	public CustomerDTO()
	{
		
	}
	public CustomerDTO(int customerId, long phoneNo, String customerEmail,
						String customerName, String customerPassword, int customerAge)
	{
		this.customerId = customerId;
		this.phoneNo = phoneNo;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerAge = customerAge;
	}
	
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
}

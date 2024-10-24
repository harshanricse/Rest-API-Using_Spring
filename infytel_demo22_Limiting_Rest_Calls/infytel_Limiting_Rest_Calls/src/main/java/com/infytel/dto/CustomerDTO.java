package com.infytel.dto;



//Data Transfer Object that carries data from one layer to another
public class CustomerDTO 
{
	
	private String email;
	private String name;
	private Integer limitness;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getLimitness() {
		return limitness;
	}

	public void setLimitness(Integer limitness) {
		this.limitness = limitness;
	}
}

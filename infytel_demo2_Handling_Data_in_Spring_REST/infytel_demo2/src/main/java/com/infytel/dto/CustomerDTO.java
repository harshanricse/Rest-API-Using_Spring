package com.infytel.dto;





import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.xml.bind.annotation.XmlRootElement;

//Data Transfer Object that carries data from one layer to another
@XmlRootElement
public class CustomerDTO 
{
	
	private String email;
	@JsonIgnore
	private String name;

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
}

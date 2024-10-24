package com.infytel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Entity class that should be passed around for DB related operations
@Entity 
public class Customer 
{
	//Annotation that helps marking a field as the primary key
	@Id 
	private String email;
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

package com.infytel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//Entity class that should be passed around for DB related operations
@Entity 
public class Customer 
{
	//Annotation that helps marking a field as the primary key
	@Id 
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

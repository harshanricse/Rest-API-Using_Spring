package com.infytel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Entity class that should be passed around for DB related operations
@Entity
@Table(name = "plan")
public class Plan {
	//Annotation that helps marking a field as the primary key
	@Id
	//Annotation that helps bridging the difference in the names between the entity and the persistence area
	//But, not mandatory if the names are same in both the contexts
	@Column(name = "plan_id")
	//Required if value to be generated automatically
	@GeneratedValue
	Integer planId;
	@Column(name = "plan_name")
	String planName;
	@Column(name = "national_rate")
	Integer nationalRate;
	@Column(name = "local_rate")
	Integer localRate;
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	
	public Integer getNationalRate() {
		return nationalRate;
	}
	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}
	public Integer getLocalRate() {
		return localRate;
	}
	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}
	public Plan() {
		super();
	}

	
}

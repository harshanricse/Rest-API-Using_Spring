package com.infytel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan {
	//Annotation that helps marking a field as the primary key
	@Id
	//Annotation that helps bridging the difference in the names between the entity and the persistence area
	@Column(name = "plan_id")
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

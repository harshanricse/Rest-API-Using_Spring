package com.infytel.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerDTO {

	private Integer customerId;
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
	private LocalDateTime simActivatedDateTime;
	private LocalDateTime subscriptionExpiredTime;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public LocalDateTime getSimActivatedDateTime() {
		return simActivatedDateTime;
	}

	public void setSimActivatedDateTime(LocalDateTime simActivatedDateTime) {
		this.simActivatedDateTime=simActivatedDateTime;
	}

	public LocalDateTime getSubscriptionExpiredTime() {
		return subscriptionExpiredTime;
	}

	public void setSubscriptionExpiredTime(LocalDateTime subscriptionExpiredTime) {
		this.subscriptionExpiredTime = subscriptionExpiredTime;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", simActivatedDateTime=" + simActivatedDateTime + ", subscriptionExpiredTime="
				+ subscriptionExpiredTime + "]";
	}

	


	




}

package com.infytel.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infytel.dto.CustomerDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String emailId;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime simActivatedDateTime;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
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
		this.simActivatedDateTime = simActivatedDateTime;
	}

	public LocalDateTime getSubscriptionExpiredTime() {
		return subscriptionExpiredTime;
	}

	public void setSubscriptionExpiredTime(LocalDateTime subscriptionExpiredTime) {
		this.subscriptionExpiredTime = subscriptionExpiredTime;
	}

	@Override
	public int hashCode() {

		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		if (this.getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!this.getCustomerId().equals(other.getCustomerId()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", simActivatedDateTime=" + simActivatedDateTime + ", subscriptionExpiredTime="
				+ subscriptionExpiredTime + "]";
	}

	

	

	

}

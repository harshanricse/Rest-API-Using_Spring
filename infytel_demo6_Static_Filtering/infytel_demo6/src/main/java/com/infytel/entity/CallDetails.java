package com.infytel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "calldetails")
public class CallDetails {

	@Id
	@GeneratedValue
	@Column(name="call_id")
	long callId;
	@Column(name="called_by")
	long calledBy;
	@Column(name="called_to")
	long calledTo;
	@Column(name="called_on")
	LocalDate calledOn;
	@Column(name="call_duration")
	int callDuration;

	

	public long getCallId() {
		return callId;
	}
	public long getCalledBy() {
		return calledBy;
	}

	public void setCalledBy(long calledBy) {
		this.calledBy = calledBy;
	}

	public long getCalledTo() {
		return calledTo;
	}

	public void setCalledTo(long calledTo) {
		this.calledTo = calledTo;
	}

	public LocalDate getCalledOn() {
		return calledOn;
	}

	public void setCalledOn(LocalDate calledOn) {
		this.calledOn = calledOn;
	}

	public int getDuration() {
		return callDuration;
	}

	public void setDuration(int callDuration) {
		this.callDuration = callDuration;
	}

}

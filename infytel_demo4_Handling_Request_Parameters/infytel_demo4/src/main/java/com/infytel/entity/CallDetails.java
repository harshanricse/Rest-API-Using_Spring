package com.infytel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
;

//Entity class that should be passed around for DB related operations
@Entity
@Table(name = "calldetails")
public class CallDetails 
{
	//Annotation that helps marking a field as the primary key
	@Id
	//Needed if the value should get generated automatically
	@GeneratedValue
	//Annotation that helps bridging the difference in the names between the entity and the persistence area
	//But, not mandatory if the names are same in both the contexts
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

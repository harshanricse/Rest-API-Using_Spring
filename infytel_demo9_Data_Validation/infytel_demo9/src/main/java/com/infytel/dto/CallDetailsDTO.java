package com.infytel.dto;

import java.time.LocalDate;

//Data Transfer Object that carries data from one layer to another
public class CallDetailsDTO {

	private long callId;
	private long calledBy;
	private long calledTo;
	private LocalDate calledOn;
	private int callDuration;
	
	public long getCallId() {
		return callId;
	}

	public void setCallId(long callId) {
		this.callId = callId;
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

	public int getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}

	@Override
	public String toString() {
		return "CallDetailsDTO [calledBy=" + calledBy + ", calledTo=" + calledTo + ", calledOn=" + calledOn
				+ ", duration=" + callDuration + "]";
	}
	
 



}

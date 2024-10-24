package com.infytel.exceptions;

public class PlanNotFoundException extends Exception {
 
	private static final long serialVersionUID = 1L;
	public PlanNotFoundException(String errors) {
		super(errors);
	}
}

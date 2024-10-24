package com.infytel.exceptions;

public class CustomerNotFoundException extends Exception {
 
	private static final long serialVersionUID = 1L;
	public CustomerNotFoundException(String errors) {
		super(errors);
	}
}

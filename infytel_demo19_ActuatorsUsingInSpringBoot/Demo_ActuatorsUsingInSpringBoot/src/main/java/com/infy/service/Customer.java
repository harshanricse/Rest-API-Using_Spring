package com.infy.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infy.exception.InfyTelException;

@Component
public class Customer {
	@Autowired
	private Plan plan;

	public String register() throws InfyTelException{
		try {
			if (plan.enrollToPlan()) {
				return "Customer enrolled to plan successfully";
			} else {
				
				throw new InfyTelException("Customer not registered. Pls try again.");
			}
		} catch (InfyTelException e) {
			Log Logger = LogFactory.getLog(this.getClass());
			
			Logger.error(e.getMessage(),e);
			throw e;
		}
		
	}
}

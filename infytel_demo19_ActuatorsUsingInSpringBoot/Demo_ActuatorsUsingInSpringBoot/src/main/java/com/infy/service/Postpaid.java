package com.infy.service;

import org.springframework.stereotype.Component;

@Component
public class Postpaid implements Plan{
	
	@Override
	public Boolean enrollToPlan() {
		
		return true;
	}

}

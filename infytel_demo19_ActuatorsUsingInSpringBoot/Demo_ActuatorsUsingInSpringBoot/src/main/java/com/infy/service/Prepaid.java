package com.infy.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Prepaid implements Plan{

	
	@Override
	public Boolean enrollToPlan() {
		
		return true;
	}

}

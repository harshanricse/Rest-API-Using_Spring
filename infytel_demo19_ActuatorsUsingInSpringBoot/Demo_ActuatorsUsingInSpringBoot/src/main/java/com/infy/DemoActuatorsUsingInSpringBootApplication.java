package com.infy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infy.service.Customer;

@SpringBootApplication
public class DemoActuatorsUsingInSpringBootApplication implements CommandLineRunner{
	
	private static final Log LOGGER = LogFactory.getLog(DemoActuatorsUsingInSpringBootApplication.class);
	
	@Autowired
	Customer cust;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoActuatorsUsingInSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info(cust.register());
	}

}

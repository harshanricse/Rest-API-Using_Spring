package com.infytel.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infytel.entity.Customer;
import com.infytel.service.CustomerService;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;

@RestController
@RequestMapping("/customers")
public class CustomerController 
{
	Bucket bucket=null;
	@Autowired
	private CustomerService customerService;
	
	
	

	
	@GetMapping("/token")
	public ResponseEntity<String> TokenGeneration()
	{
		Refill refill=Refill.of(5, Duration.ofMinutes(1));
		bucket=Bucket4j.builder().addLimit(Bandwidth.classic(5, refill))
				      .build();
		return new ResponseEntity<String>("Token Generated Successfully "+bucket.toString(), HttpStatus.OK);
	}
	
	//Fetches the existing set of customers
	@GetMapping("/{phno}")
	public String fetchCustomers(@PathVariable("phno") String email)
	{Customer cust=null;
		if(bucket.tryConsume(1))
		{
		return customerService.fetchCustomers(email).getName();
		}
		else
		{
			return "To many Requests";
		}
		
	}
}

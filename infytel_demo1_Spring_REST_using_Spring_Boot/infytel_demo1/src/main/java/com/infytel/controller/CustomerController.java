package com.infytel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infytel.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	private String email = "John@infytel.com";
	private String name = "John";
	
	//Creates a new customer
	@PostMapping
	public String createCustomer()
	{
		 return customerService.createCustomer(email,name);
	}
	
	//Deletes an existing customer
	@DeleteMapping
	public String deleteCustomer()
	{
		return customerService.deleteCustomer(email);
	}
	
	//Updates an existing customer
	@PutMapping
	public String updateCustomer()
	{
		return customerService.updateCustomer(email,"Johnson");
	}
	
	//Fetches the existing set of customers
	@GetMapping
	public String fetchCustomers()
	{
		return customerService.fetchCustomers();
	}
}

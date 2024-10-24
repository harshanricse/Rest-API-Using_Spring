package com.infytel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.EntityListCustomer;
import com.infytel.exceptions.CustomerNotFoundException;
import com.infytel.service.CustomerService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/customers")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	@PostMapping(produces="application/xml")//Creates a new customer
	public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO )
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDTO));
	}
	@DeleteMapping //Deletes an existing customer
	public String deleteCustomer()
	{
		return customerService.deleteCustomer(6231);//hard-coded customerId here. Make the service end-point receive the same from the client.
	}
	@PutMapping(value = "/{customerId}", consumes = "application/json") //Updates an existing customer
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("customerId") int customerId,@RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customerId,customerDTO));
	}
	@GetMapping(produces= {"application/xml","application/json"})//Fetches a list of customers
	public ResponseEntity<EntityListCustomer<CustomerDTO>> fetchCustomers()
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomers());
	}
}

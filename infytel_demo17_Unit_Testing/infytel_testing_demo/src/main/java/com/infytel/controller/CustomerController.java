package com.infytel.controller;

import java.util.List;

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
import com.infytel.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// Fetches the existing set of customers
	@GetMapping
	public List<CustomerDTO> fetchCustomers() {

		return customerService.fetchCustomers();
	}
	
	// Creates a new customer
	@PostMapping(produces = "application/json")
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {

		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDTO));
	}

	// Updates an existing customer
	@PutMapping(value = "/{customerId}", consumes = "application/json")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("customerId") int customerId,
													  @RequestBody CustomerDTO customerDTO) {
		
		return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customerId, customerDTO));
	}

	// Deletes an existing customer
	@DeleteMapping("{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int customerId) {

		return customerService.deleteCustomer(customerId); 
	}
}

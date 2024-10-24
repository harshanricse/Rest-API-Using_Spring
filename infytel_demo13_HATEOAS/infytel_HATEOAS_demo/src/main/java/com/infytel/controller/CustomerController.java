package com.infytel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
		
	//Creates a new customer
	@PostMapping
	public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO )
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDTO));
	}
	
	//Deletes an existing customer
	@DeleteMapping
	public String deleteCustomer()
	{
		return customerService.deleteCustomer(6231);//hard-coded customerId here. Make the service end-point receive the same from the client.
	}
	
	//Updates an existing customer
	@PutMapping(value = "/{customerId}", consumes = "application/json") 
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("customerId") int customerId,
													  @Valid @RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customerId,customerDTO));
	}
	
	//Fetches a list of customers
	@GetMapping(produces= {"application/xml","application/json"})
	public ResponseEntity<EntityListCustomer<CustomerDTO>> fetchCustomers()
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomers());
	}
	
	@GetMapping("/{customerId}")
	public EntityModel<CustomerDTO> fetchCustomerById(@PathVariable("customerId") int customerId)
															 throws CustomerNotFoundException
	{
		EntityModel<CustomerDTO> customerHateoas = EntityModel.of(
													customerService.fetchCustomerById(customerId));
		//code for creating links using WebMvcLinkBuilder
		WebMvcLinkBuilder linkTo1 = WebMvcLinkBuilder.linkTo(
													WebMvcLinkBuilder.methodOn(this.getClass()).
													updateCustomer(customerId, new CustomerDTO()));
		
		
		customerHateoas.add(linkTo1.withSelfRel().withRel("updatecustomer"));
		customerHateoas.add(Link.of("http://localhost:9000/infytel/plans").withRel("plans"));
		return customerHateoas; 
	}
	
}

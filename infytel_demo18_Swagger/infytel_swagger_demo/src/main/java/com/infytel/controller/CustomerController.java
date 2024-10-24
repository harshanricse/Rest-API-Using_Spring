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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.EntityListCustomer;
import com.infytel.exceptions.CustomerNotFoundException;
import com.infytel.service.CustomerService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/customers")
@OpenAPIDefinition(info = @Info(title = "Controller layer for customer related operations",
version = "3.14"))
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	@PostMapping(produces="application/xml")//Creates a new customer
	/*
	 * {
	"customerPhoneNo": 8500736467,
	"customerEmail": "harsha@gmail.com",
	"customerName": "harsha",
	"customerPassword": "5aA$10",
	"customerAge": 25,
	
}
	 */
	
	public ResponseEntity<CustomerDTO> createCustomer(@RequestParam("id") Integer customerId, @RequestParam("phno")Long customerPhoneNo, @RequestParam("email") String customerEmail,@RequestParam("name") String customerName,@RequestParam("pass")String customerPassword,@RequestParam("age") Integer customerAge /*@Valid @RequestBody CustomerDTO customerDTO*/ )
	{
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customerId);
		customerDTO.setcustomerPhoneNo(customerPhoneNo);
		customerDTO.setCustomerEmail(customerEmail);
		customerDTO.setCustomerName(customerName);
		customerDTO.setCustomerPassword(customerPassword);
		customerDTO.setCustomerAge(customerAge);
		System.out.println("debugging purpose"+customerDTO);
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
	@ApiResponse(description="Get method for fetching customer details")
	@GetMapping(produces= {"application/xml","application/json"})//Fetches a list of customers
	public ResponseEntity<EntityListCustomer<CustomerDTO>> fetchCustomers()
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomers());
	}
}

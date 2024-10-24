package com.infytel.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	//Creates a new customer
	@PostMapping(produces="application/xml")
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO )
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
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody CustomerDTO customerDTO) 
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customerId,customerDTO));
	}
	
	//Fetches the existing set of customers and ignores the fields for serialization based on the 
	//header information being shared by the client
	@GetMapping
	public MappingJacksonValue fetchCustomers(@RequestHeader HttpHeaders httpHeaders)
	{
		List<CustomerDTO> customerDTOs = customerService.fetchCustomers(); 
		
		//getting the header values stored in a list
		List<String> fieldsFromHeader = httpHeaders.getValuesAsList("fieldsRequired");
		
		Set<String> fieldsToInclude = new HashSet<>();
		for(String field : fieldsFromHeader)
		{
			fieldsToInclude.add(field);//content of list gets stored in the set named fieldsToInclude
		}
		
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToInclude);//set of fields get passed here
		
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("CustomerFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(customerDTOs);
		//MappingJacksonValue in place to help serialization with a filter
		mapping.setFilters(filters);
		return mapping;
	}
}

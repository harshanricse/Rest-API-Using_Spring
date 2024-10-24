package com.infytel.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import com.infytel.exception.InfyTelException;
import com.infytel.service.CustomerService;

@RestController
@RequestMapping(value = "/infytel")
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private Environment environment;

	@GetMapping(value = "/customers") // fetching all customers
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() throws InfyTelException {
		List<CustomerDTO> customerList = customerService.getAllCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	/*
	 * finding a customer by using dateOfBirth, here we are passing dateOfBirth as LocalDate type directly into PathVariable 
	 */
	@GetMapping(value = "/customers/findCustomerbyDOB/{dateOfBirth}") // finding a customer by using dateOfBirth
	public ResponseEntity<CustomerDTO> getCustomerByDob(@PathVariable LocalDate dateOfBirth) throws InfyTelException {
		CustomerDTO customer = customerService.getCustomerByDob(dateOfBirth);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	/*
	 * finding a customer by using dateOfBirth, here we are passing dateOfBirth as a
	 * String in PathVariable and inside the method we can parse it into LocalDate
	 * like shown in the below method
	 * 
	 */
	@GetMapping(value = "/customers/findCustomerbyDOB/dobAsString/{dateOfBirth}")
	public ResponseEntity<CustomerDTO> getCustomerByDob2(@PathVariable String dateOfBirth) throws InfyTelException {
		CustomerDTO customer = customerService.getCustomerByDob(LocalDate.parse(dateOfBirth));
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping(value = "/customers/findCustomerbyId/{customerId}") // finding a customer by using customerId
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws InfyTelException {
		CustomerDTO customer = customerService.getCustomer(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping(value = "/customers") // Inserting customer
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customer) throws InfyTelException {
		Integer customerId = customerService.addCustomer(customer);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value = "/customers/{customerId}/{emailId}") // Updating customer
	public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @PathVariable String emailId)
			throws InfyTelException {
		customerService.updateCustomer(customerId, emailId);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@DeleteMapping(value = "/customers/{customerId}") // Deleting a customer
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws InfyTelException {
		customerService.deleteCustomer(customerId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

}

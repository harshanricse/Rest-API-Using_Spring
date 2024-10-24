package com.infytel.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerDTO;
import com.infytel.entity.Customer;
import com.infytel.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Fetches the existing set of customers
	public List<CustomerDTO> fetchCustomers() {
		
		List<CustomerDTO> dtoList = new ArrayList<>();
		
		customerRepository.findAll()
			              .forEach(customer -> dtoList.add(modelMapper.map(customer, CustomerDTO.class))); 
			
		// Above statement helps fetching the customer details from the DB and making a list.
		// Exception will get raised, if something goes wrong while carrying out the same.
		// You can place an appropriate exception handling code in order to deal with the same.

		return dtoList;
	}
	
	// Creates a new customer
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		
		Customer customer = customerRepository.saveAndFlush(modelMapper.map(customerDTO, Customer.class));
		// Above statement helps persisting the customer in the DB.
		// Exception will get raised, if something goes wrong while carrying out the same.
		// You can place an appropriate exception handling code in order to deal with the same.
		
		return modelMapper.map(customer, CustomerDTO.class);
	}
	
	// Updates an existing customer
	public CustomerDTO updateCustomer(int customerId, CustomerDTO customerDTO) {
		
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		
		Customer customer = null;
		
		if (customerOptional.isPresent()) {
			
			customer = customerOptional.get();
			customer.setCustomerEmail(customerDTO.getCustomerEmail()); // Setting a new email received in the request and 
																		// any no. of fields can be set with new values this way
			customerRepository.saveAndFlush(customer);
			// Above statement helps updating the email of customer with particular id.
			// Exception will get raised, if something goes wrong while carrying out the same.
			// You can place an appropriate exception handling code in order to deal with the same.
		}
		
		return modelMapper.map(customer, CustomerDTO.class);
	}

	// Deletes an existing customer
	public String deleteCustomer(int customerId) {
		
		customerRepository.deleteById(customerId);
		// Above statement helps deleting the customer of particular id from the DB.
		// Exception will get raised, if something goes wrong while carrying out the same.
		// You can place an appropriate exception handling code in order to deal with the same.
		
		return "Deleted customer successfully";
	}
}

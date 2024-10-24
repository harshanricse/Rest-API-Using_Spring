package com.infytel.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerDTO;
import com.infytel.entity.Customer;
import com.infytel.repository.CustomerRepository;

//Service/business layer
@Service
public class CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//Creates a new customer
	public String createCustomer(String email, String name)
	{
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setEmail(email);
		customerDTO.setName(name);
		customerRepository.saveAndFlush(modelMapper.map(customerDTO, Customer.class));
		//Above statement helps persisting the customer in the DB. 
		//Exception will get raised, if something goes wrong while carrying out the same.
		//You can place the appropriate exception handling code in order to deal with the same. 
		return "Created customer successfully";
	}
	
	//Deletes an existing customer
	public String deleteCustomer(String email)
	{
		customerRepository.deleteById(email);
		//Above statement helps deleting the customer of particular email from the DB. 
		//Exception will get raised, if something goes wrong while carrying out the same.
		//You can place the appropriate exception handling code in order to deal with the same. 
		return "Deleted customer successfully";
	}
	
	//Updates an existing customer
	public String updateCustomer(String emailExisting, String name)
	{
		Optional<Customer> customerOptional = customerRepository.findById(emailExisting);
		if(customerOptional.isPresent())
		{
				Customer customer = customerOptional.get();
				customer.setName(name);
				customerRepository.saveAndFlush(customer);
				//Above statement helps updating the customer of particular email to a new name. 
				//Exception will get raised, if something goes wrong while carrying out the same.
				//You can place the appropriate exception handling code in order to deal with the same.
		}
		return "Updated customer successfully";
	}
	
	//Fetches the existing set of customers
	public String fetchCustomers()
	{
		customerRepository.findAll();
		//Above statement helps fetching the customer details from the DB. 
		//Exception will get raised, if something goes wrong while carrying out the same.
		//You can place the appropriate exception handling code in order to deal with the same.
		return "Fetched customers successfully";
	}
}

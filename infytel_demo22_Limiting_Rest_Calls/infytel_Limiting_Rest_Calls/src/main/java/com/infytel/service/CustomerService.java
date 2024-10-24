package com.infytel.service;

import java.util.Optional;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	
	
	public Customer fetchCustomers(String emailid)
	{
		Optional<Customer> id=customerRepository.findById(emailid);
		
		//Above statement helps fetching the customer details from the DB. 
		//Exception will get raised, if something goes wrong while carrying out the same.
		//You can place the appropriate exception handling code in order to deal with the same.
		return id.get();
	}
}

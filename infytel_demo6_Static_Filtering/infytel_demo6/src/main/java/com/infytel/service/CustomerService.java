package com.infytel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.EntityListCustomer;
import com.infytel.entity.Customer;
import com.infytel.repository.CustomerRepository;

//service/business layer
@Service
public class CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//Creates a new customer
	public CustomerDTO createCustomer(CustomerDTO customerDTO)
	{
		Customer customer = customerRepository.saveAndFlush(modelMapper.map(customerDTO, Customer.class));
		//Above statement helps persisting the customer in the DB. 
		//Exception will get raised, if something goes wrong while carrying out the same.
		//You can place the appropriate exception handling code in order to deal with the same. 
		return modelMapper.map(customer, CustomerDTO.class);
	}
	
	//Deletes an existing customer
	public String deleteCustomer(int customerId)
	{
		customerRepository.deleteById(customerId);
		//Above statement helps deleting the customer of particular email from the DB. 
		//Exception will get raised, if something goes wrong while carrying out the same.
		//You can place the appropriate exception handling code in order to deal with the same. 
		return "Deleted customer successfully";
	}
	
	//Updates an existing customer
	public CustomerDTO updateCustomer(int customerId, CustomerDTO customerDTO)
	{
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		Customer customer = null;
		if(customerOptional.isPresent())
		{
				customer = customerOptional.get();
				customer.setCustomerEmail(customerDTO.getCustomerEmail());//updating the existing name and any no of fields can be updated this way
				customerRepository.saveAndFlush(customer);
				//Above statement helps updating the customer of particular email to a new name. 
				//Exception will get raised, if something goes wrong while carrying out the same.
				//You can place the appropriate exception handling code in order to deal with the same.
		}
		return modelMapper.map(customer, CustomerDTO.class);
	}
	
	//Fetches the existing set of customers
	public EntityListCustomer<CustomerDTO> fetchCustomers()
	{
		List<Customer> customerEntities = customerRepository.findAll();
		EntityListCustomer<CustomerDTO> customers;
		//Above statement helps fetching the customer details from the DB. 
		//Exception will get raised, if something goes wrong while carrying out the same.
		//You can place the appropriate exception handling code in order to deal with the same.
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		for(Customer customer : customerEntities)
		{
			customerDTOs.add(modelMapper.map(customer, CustomerDTO.class));
		}
		customers = new EntityListCustomer<>(customerDTOs);
		return customers;
	}
}

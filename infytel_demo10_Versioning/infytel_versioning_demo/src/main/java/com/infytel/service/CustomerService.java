package com.infytel.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.CustomerDTOVersion2;
import com.infytel.entity.Customer;
import com.infytel.exceptions.CustomerNotFoundException;
import com.infytel.repository.CustomerRepository;
import com.infytel.util.InfyTelConstants;

//service/business layer
@Service
@PropertySource("classpath:ValidationMessages.properties")
public class CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;
	
	
		
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Environment environment;
	
	
	
	
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
		return environment.getProperty(InfyTelConstants.CUSTOMER_DELETE_SUCCESS.toString());
	}
	
	//Updates an existing customer
	public CustomerDTO updateCustomer(int customerId, CustomerDTO customerDTO)throws CustomerNotFoundException
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
		else
		{
			throw new CustomerNotFoundException(environment.getProperty(InfyTelConstants.CUSTOMER_NOT_FOUND.toString()));
		}
		return modelMapper.map(customer, CustomerDTO.class);
	}
	public List<CustomerDTO> fetchCustomers()
	{
		List<CustomerDTO> customerDTO= new ArrayList<>();
		List<Customer> customers = customerRepository.findAll();
		for(Customer customer : customers)
		{
			customerDTO.add(modelMapper.map(customer,CustomerDTO.class));
		}
		return customerDTO;
	}
		
	public List<CustomerDTOVersion2> fetchCustomersVersion2()
	{
		List<CustomerDTOVersion2> customerDTOVersion2= new ArrayList<>();
		List<Customer> customers = customerRepository.findAll();
		for(Customer customer : customers)
		{
			customerDTOVersion2.add(modelMapper.map(customer,CustomerDTOVersion2.class));
		}
		return customerDTOVersion2;
	}
}

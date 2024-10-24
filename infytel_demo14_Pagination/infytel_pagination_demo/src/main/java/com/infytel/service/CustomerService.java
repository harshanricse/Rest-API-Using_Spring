package com.infytel.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import com.infytel.dto.CustomerDTO;
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
	
	@Autowired
	PagedResourcesAssembler<Customer> assembler;
	
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
	
	
			
	public PagedModel<CustomerDTO> fetchCustomers(int pageNo, int pageSize)
	{
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Customer> pagedResult= customerRepository.findAll(pageable);
		PagedModel<EntityModel<Customer>> pagedModel = assembler.toModel(pagedResult);
		Iterator<EntityModel<Customer>> it = pagedModel.getContent().iterator();
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		while(it.hasNext())
		{
			EntityModel<Customer> ent = it.next();
			Customer customer = ent.getContent();
			customerDTOs.add(modelMapper.map(customer, CustomerDTO.class));
		}
		
		return	PagedModel.of(customerDTOs, pagedModel.getMetadata(), pagedModel.getLinks());	
	}
}

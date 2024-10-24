package com.infytel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.EntityListCustomer;
import com.infytel.dto.PlanDTO;
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
	private RestTemplate restTemplate;
	//Creates a new customer
	public CustomerDTO createCustomer(CustomerDTO customerDTO)
	{
		Customer customer = customerRepository.saveAndFlush(modelMapper.map(customerDTO, Customer.class));
		//Above statement helps persisting the customer in the DB. 
		//Exception will get raised, if something goes wrong while carrying out the same.
		//You can place the appropriate exception handling code in order to deal with the same. 
		CustomerDTO customerDTOReceived = modelMapper.map(customer, CustomerDTO.class);
		ResponseEntity<PlanDTO> planEntity = restTemplate.getForEntity("http://localhost:8080/infytel/plans/"+customerDTO.getPlanDTO().getPlanId(), PlanDTO.class);
		customerDTOReceived.setPlanDTO(planEntity.getBody());
		
		return customerDTOReceived;
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
		public CustomerDTO fetchCustomerById(int customerId)throws CustomerNotFoundException
		{
			CustomerDTO customerDTO = null;
			Optional<Customer> customerOptional = customerRepository.findById(customerId);
			if(customerOptional.isPresent())
			{
				Customer customer = customerOptional.get();
				int planId = customer.getPlanId();
				ResponseEntity<PlanDTO> plan = restTemplate.getForEntity("http://localhost:8080/infytel/plans/"+planId, PlanDTO.class);
				PlanDTO planDTO = plan.getBody();
				customerDTO = modelMapper.map(customer, CustomerDTO.class);
				customerDTO.setPlanDTO(planDTO);
			}
			else 
			{
				throw new CustomerNotFoundException(environment.getProperty(InfyTelConstants.CUSTOMER_NOT_FOUND.toString()));
			}
			return customerDTO;
		}
}

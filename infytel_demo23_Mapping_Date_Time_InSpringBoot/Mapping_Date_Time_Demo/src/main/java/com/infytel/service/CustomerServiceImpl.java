package com.infytel.service;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infytel.repository.CustomerRepository;
import com.infytel.exception.InfyTelException;
import com.infytel.entity.Customer;
import com.infytel.dto.CustomerDTO;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO getCustomerByDob(LocalDate dateOfBirth) throws InfyTelException {
		Optional<Customer> optional = customerRepository.findByDateOfBirth(dateOfBirth);
		Customer customer = optional.orElseThrow(() -> new InfyTelException("Service.CUSTOMER_NOT_FOUND"));
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setCustomerId(customer.getCustomerId());
		customer2.setDateOfBirth(customer.getDateOfBirth());
		customer2.setEmailId(customer.getEmailId());
		customer2.setName(customer.getName());
		customer2.setSimActivatedDateTime(customer.getSimActivatedDateTime());
		customer2.setSubscriptionExpiredTime(customer.getSubscriptionExpiredTime());
		return customer2;
	}

	@Override
	@Cacheable(value = "customerCache", key = "#customerId")
	public CustomerDTO getCustomer(Integer customerId) throws InfyTelException {
		System.out.println("Fetching customer details with cid: " + customerId);
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new InfyTelException("Service.CUSTOMER_NOT_FOUND"));
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setCustomerId(customer.getCustomerId());
		customer2.setDateOfBirth(customer.getDateOfBirth());
		customer2.setEmailId(customer.getEmailId());
		customer2.setName(customer.getName());
		customer2.setSimActivatedDateTime(customer.getSimActivatedDateTime());
		customer2.setSubscriptionExpiredTime(customer.getSubscriptionExpiredTime());
		
		return customer2;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() throws InfyTelException {
		Iterable<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customers2 = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerId(customer.getCustomerId());
			cust.setDateOfBirth(customer.getDateOfBirth());
			cust.setEmailId(customer.getEmailId());
			cust.setName(customer.getName());
			cust.setSimActivatedDateTime(customer.getSimActivatedDateTime());
			cust.setSubscriptionExpiredTime(customer.getSubscriptionExpiredTime());
			
			customers2.add(cust);
		});
		if (customers2.isEmpty())
			throw new InfyTelException("Service.CUSTOMERS_NOT_FOUND");
		return customers2;
	}

	@Override
	public Integer addCustomer(CustomerDTO cDto) throws InfyTelException {
		Customer customerEntity = new Customer();
		customerEntity.setName(cDto.getName());
		customerEntity.setEmailId(cDto.getEmailId());
		customerEntity.setDateOfBirth(cDto.getDateOfBirth());
		customerEntity.setSimActivatedDateTime(cDto.getSimActivatedDateTime());
		customerEntity.setSubscriptionExpiredTime(cDto.getSubscriptionExpiredTime());
		Customer addedCustomer = customerRepository.save(customerEntity);
		return addedCustomer.getCustomerId();
	}

	@Override
	public void updateCustomer(Integer customerId, String emailId) throws InfyTelException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		Customer c = customer.orElseThrow(() -> new InfyTelException("Service.CUSTOMER_NOT_FOUND"));
		c.setEmailId(emailId);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws InfyTelException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		customer.orElseThrow(() -> new InfyTelException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.deleteById(customerId);
	}
	
	

}

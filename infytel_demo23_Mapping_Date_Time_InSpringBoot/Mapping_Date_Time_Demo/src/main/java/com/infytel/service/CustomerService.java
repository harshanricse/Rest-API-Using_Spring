package com.infytel.service;

import java.time.LocalDate;
import java.util.List;
import com.infytel.dto.CustomerDTO;
import com.infytel.exception.InfyTelException;

public interface CustomerService {
	public CustomerDTO getCustomer(Integer customerId) throws InfyTelException;
	public List<CustomerDTO> getAllCustomers() throws InfyTelException;
	public Integer addCustomer(CustomerDTO customer) throws InfyTelException;
	public void updateCustomer(Integer customerId, String emailId) throws InfyTelException;
	public void deleteCustomer(Integer customerId) throws InfyTelException;
	public CustomerDTO getCustomerByDob(LocalDate dateOfBirth) throws InfyTelException;
	
}

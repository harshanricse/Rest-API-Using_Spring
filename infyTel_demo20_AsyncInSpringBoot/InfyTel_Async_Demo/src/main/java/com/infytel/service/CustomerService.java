package com.infytel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerDTO;
import com.infytel.entity.Customer;
import com.infytel.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepo;

//	@Async
	public void sendFestiveOfferMail() {
		// fetching all customers from repository
		List<Customer> cList = custRepo.findAll();
		try {
			for (Customer c : cList) {
				sendTextMsg(c);
			}
		} catch (Exception e) {

		}
	}

	private void sendTextMsg(Customer c) {

		try {
			Thread.sleep(2000);
			// by using 3rd party services we are sending mails
			System.out.println("The mail has been sent to Customer : " + c.getCname() + "\n by using the thread : "
					+ Thread.currentThread().getName());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public List<Customer> addCustomer(List<CustomerDTO> custDTOlist) {

		return custDTOlist.stream().map(this::convertDtoToEntity).collect(Collectors.toList());
	}

	private Customer convertDtoToEntity(CustomerDTO customerdto) {
		Customer customer = new Customer();
		customer.setCname(customerdto.getCname());
		customer.setEmail(customerdto.getEmail());
		customer.setRole(customerdto.getRole());
		return custRepo.save(customer);
	}

	public Customer addCustomer(CustomerDTO custDTO) {
		Customer c = new Customer();
		c.setCname(custDTO.getCname());
		c.setEmail(custDTO.getEmail());
		c.setRole(custDTO.getRole());
		return custRepo.save(c);
	}

	public List<Customer> getAllCustomers() {
		return custRepo.findAll();
	}

	public Optional<Customer> getCustomerById(Long cid) {
		return custRepo.findById(cid);
	}

}

package com.infytel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infytel.dto.CustomerDTO;
import com.infytel.entity.Customer;
import com.infytel.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService custServ;
	
	@PostMapping//for adding individual customer
	public Customer addCustomer(@RequestBody CustomerDTO custDTO) {
		return custServ.addCustomer(custDTO);
	}
	
	@PostMapping("/add/addListOfCust")//for adding multiple customers at a time
	public List<Customer> addCustomer(@RequestBody List<CustomerDTO> custDTOList) {
		return custServ.addCustomer(custDTOList);
	}

	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return custServ.getAllCustomers();
	}
	
	@GetMapping("/{cid}")
	public Optional<Customer> getCustomerById(@PathVariable Long cid){
		return custServ.getCustomerById(cid);
	}
	
	
	

	
}

package com.infytel.controller.test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infytel.controller.CustomerController;
import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;

@WebMvcTest(CustomerController.class)
class TestCustomerController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void testCreateCustomerValid() throws Exception
	{
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setCustomerId(1001);
		customerDTO.setCustomerName("John");
		customerDTO.setCustomerEmail("John@infy.com");
		
		Mockito.when(customerService.createCustomer(customerDTO))
				.thenReturn(customerDTO);
		
		mockMvc.perform(post("/customers").content(objectMapper.writeValueAsString(customerDTO))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.customerId", is(1001)))
				.andExpect(jsonPath("$.customerName", is("John")))
				.andExpect(jsonPath("$.customerEmail", is("John@infy.com")))
				.andDo(print());
				
		Mockito.verify(customerService).createCustomer(customerDTO);
	}
	
	@Test
	void testDeleteCustomerValid() throws Exception
	{
		int customerId = 1001;
		
		Mockito.when(customerService.deleteCustomer(customerId))
		.thenReturn("Deleted customer successfully");
		
		mockMvc.perform(delete("/customers/{customerId}", customerId))
				.andExpect(status().isOk())
				.andExpect(content().string("Deleted customer successfully"))
				.andDo(print());
		
		Mockito.verify(customerService).deleteCustomer(customerId);
	}	
}

package com.infytel.controller;

import java.time.LocalDate;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.infytel.dto.CallDetailsDTO;

import com.infytel.service.CallDetailsService;

import jakarta.validation.constraints.PastOrPresent;

@RestController
@RequestMapping("/calldetails")
@Validated//Validating URI parameters
public class CallDetailsController 
{
	@Autowired
	private CallDetailsService callDetailsService;
	
	//Fetching call details based on the request parameters being received
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<CallDetailsDTO>> fetchCallDetails
									(@RequestParam("calledBy")
									 long calledBy,
									 @RequestParam("calledOn") 
									 @DateTimeFormat(pattern="MM-dd-yyyy") 
									 @PastOrPresent(message="{call.calledon.invalid}") LocalDate calledOn)
	{
		return ResponseEntity.status(HttpStatus.OK).body(callDetailsService.fetchCallDetails(calledBy, calledOn));   
	}
}

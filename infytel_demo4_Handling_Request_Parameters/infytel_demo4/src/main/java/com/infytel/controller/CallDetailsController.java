package com.infytel.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infytel.dto.CallDetailsDTO;
import com.infytel.entity.CallDetails;
import com.infytel.service.CallDetailsService;

@RestController
@RequestMapping("/calldetails")
public class CallDetailsController 
{
	@Autowired
	private CallDetailsService callDetailsService;
	@Autowired
	private ModelMapper modelMapper;
	
	//Fetching call details based on the request parameters being passed in the URI
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<CallDetailsDTO>> fetchCallDetails(@RequestParam("calledBy") long calledBy, @RequestParam("calledOn") String calledOn)
	{
		List<CallDetailsDTO> callDetailsDTO = new ArrayList<>();
		List<CallDetails> callDetailsEntity = callDetailsService.fetchCallDetails(calledBy, LocalDate.parse(calledOn, DateTimeFormatter.ofPattern("MM-dd-yyyy")));
		for(CallDetails callDetails : callDetailsEntity)
		{
			callDetailsDTO.add(modelMapper.map(callDetails,CallDetailsDTO.class));
		}
		return ResponseEntity.status(HttpStatus.OK).body(callDetailsDTO);   
	}
}

package com.infytel.service;

import java.time.LocalDate;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import com.infytel.dto.CallDetailsDTO;
import com.infytel.entity.CallDetails;
import com.infytel.repository.CallDetailsRepository;
//service/business layer
@Service
public class CallDetailsService 
{
	@Autowired
	private CallDetailsRepository callDetailsRepository;
	@Autowired
	private ModelMapper modelMapper;
	//contacts repository to fetch the call details
	public List<CallDetails> fetchCallDetails(long calledBy, LocalDate calledOn)
	{
		return callDetailsRepository.fetchCallDetails(calledBy, calledOn);
	}
	@PostMapping
	public CallDetailsDTO createCallDetails(CallDetailsDTO callDetailsDTO)
	{
		CallDetails callDetails = callDetailsRepository.saveAndFlush(modelMapper.map(callDetailsDTO, CallDetails.class));
		return modelMapper.map(callDetails, CallDetailsDTO.class);
	}
}

package com.infytel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.dto.CallDetailsDTO;
import com.infytel.entity.CallDetails;
import com.infytel.repository.CallDetailsRepository;
@Service
public class CallDetailsService 
{
	@Autowired
	private CallDetailsRepository callDetailsRepository;
	@Autowired
	private ModelMapper modelMapper;
	//contacts repository to fetch the call details
	public List<CallDetailsDTO> fetchCallDetails(long calledBy, LocalDate calledOn)
	{
		List<CallDetailsDTO> callDetailsDTO = new ArrayList<>();
		List<CallDetails> callDetailsEntity =callDetailsRepository.fetchCallDetails(calledBy, calledOn);
		for(CallDetails callDetails : callDetailsEntity)
		{
			callDetailsDTO.add(modelMapper.map(callDetails,CallDetailsDTO.class));
		}
		return callDetailsDTO;
	}
}

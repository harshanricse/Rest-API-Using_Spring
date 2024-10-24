package com.infytel.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.dto.EntityListPlan;
import com.infytel.dto.PlanDTO;
import com.infytel.entity.Plan;
import com.infytel.repository.PlanRepository;

//service/business layer
@Service
public class PlanService
{
	@Autowired
	private PlanRepository plansRepository; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	private EntityListPlan<PlanDTO> plans;
	
	public EntityListPlan<PlanDTO> fetchPlans() 
	{
		List<Plan> planEntities = plansRepository.findAll();
		List<PlanDTO> planDTOs = new ArrayList<>();
		for(Plan plan : planEntities)
		{
			planDTOs.add(modelMapper.map(plan,PlanDTO.class));
		}
		plans = new EntityListPlan<>(planDTOs);
		return plans;
	} 
	
	public EntityListPlan<PlanDTO> fetchPlansByLocalRate(Set<Integer> localRatesFinal ) 
	{
		List<Plan> planEntities = plansRepository.fetchPlansByLocalRate(localRatesFinal);
		List<PlanDTO> planDTOs = new ArrayList<>();
		for(Plan plan : planEntities)
		{
			planDTOs.add(modelMapper.map(plan,PlanDTO.class));
		}
		plans = new EntityListPlan<>(planDTOs);
		return plans;
	}
	
	public PlanDTO fetchPlanById(int planId ) 
	{
		Optional<Plan> optionalPlan = plansRepository.findById(planId);
		Plan planDefault = new Plan();
		planDefault.setLocalRate(0);
		planDefault.setNationalRate(0);
		planDefault.setPlanId(0);
		planDefault.setPlanName("nosuchplan");
		Plan plan = optionalPlan.orElse(planDefault);
		return modelMapper.map(plan,PlanDTO.class);
		
	}
	
}

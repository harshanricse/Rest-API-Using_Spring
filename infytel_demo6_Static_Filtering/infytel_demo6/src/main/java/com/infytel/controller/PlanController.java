package com.infytel.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infytel.dto.EntityListPlan;
import com.infytel.dto.PlanDTO;
import com.infytel.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController 
{
	
	@Autowired
	private PlanService planService;   
	
	//Get all available plans
	@GetMapping(produces = {"application/xml"})
	public ResponseEntity<EntityListPlan<PlanDTO>> fetchPlans() 
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(planService.fetchPlans());
	}
	
	//Gets plans based on localRate being passed as matrix parameter
	@GetMapping(value = "/{query}/plan", produces = {"application/xml"})
	public ResponseEntity<EntityListPlan<PlanDTO>> fetchPlansByLocalRate(@MatrixVariable(pathVar="query") Map<String, List<Integer>> map ) 
	{
		 Set<String> keysLocalRates = map.keySet();
		 ArrayList localRates = new ArrayList();//this is raw because of the strange issue of casting and assigning
		 Set<Integer> localRatesFinal = new HashSet<>();
		for(String key : keysLocalRates)
		{
			for(int i=0;i<map.get(key).size();i++)
			{
				localRates.add(map.get(key).get(i));
				
			}
		}
		Iterator it = localRates.iterator();
		while(it.hasNext())
		{
			int rate =Integer.parseInt((String)it.next());
			localRatesFinal.add(rate);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(planService.fetchPlansByLocalRate(localRatesFinal));
	}
	
	@GetMapping("/{plan}")
	public ResponseEntity<PlanDTO> fetchPlanById(@MatrixVariable(pathVar="plan") int planId) 
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(planService.fetchPlanById(planId));
	}
	
}

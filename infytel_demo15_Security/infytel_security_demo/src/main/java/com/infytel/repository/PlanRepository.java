package com.infytel.repository;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infytel.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> 
{
	
	@Query("SELECT t FROM Plan t WHERE t.localRate IN (?1)")
    public List<Plan> fetchPlansByLocalRate(Set<Integer> localRates);

}

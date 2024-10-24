package com.infytel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infytel.entity.Customer;

//Spring Data JPA repository that helps dealing with DB related operations
public interface CustomerRepository extends JpaRepository<Customer, String>
{
     
}

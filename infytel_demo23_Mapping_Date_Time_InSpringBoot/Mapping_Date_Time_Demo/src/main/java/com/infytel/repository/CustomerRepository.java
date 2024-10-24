package com.infytel.repository;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.infytel.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Optional<Customer> findByDateOfBirth(LocalDate dateOfBirth);
}

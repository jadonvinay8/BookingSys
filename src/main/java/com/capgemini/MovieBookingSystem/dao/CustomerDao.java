package com.capgemini.MovieBookingSystem.dao;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.MovieBookingSystem.entities.Customer;

@Repository
@EnableScan
public interface CustomerDao extends CrudRepository<Customer, String> {
	
	Optional<Customer> findById(String id);
	
	
}

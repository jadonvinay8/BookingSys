package com.capgemini.MovieBookingSystem.dao;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.MovieBookingSystem.entities.Customer;

@Repository
@EnableScan
public interface CustomerDao extends PagingAndSortingRepository<Customer, String> {
	
	Optional<Customer> findById(String id);
	
	
}

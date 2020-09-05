package com.capgemini.MovieBookingSystem.dao;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.MovieBookingSystem.entities.Theater;

@Repository
@EnableScan
public interface TheaterDAO extends CrudRepository<Theater, String>{

	Optional<Theater> findById(String id);
	
}

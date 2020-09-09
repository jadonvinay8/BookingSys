package com.capgemini.MovieBookingSystem.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.MovieBookingSystem.entities.User;

@Repository
@EnableScan
public interface UserDao extends PagingAndSortingRepository<User, String> {
	
}

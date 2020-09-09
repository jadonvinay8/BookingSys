package com.capgemini.MovieBookingSystem.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.MovieBookingSystem.entities.SeatPlan;

@Repository
@EnableScan
public interface SeatPlanDao extends PagingAndSortingRepository<SeatPlan, String> {
	
}

package com.capgemini.MovieBookingSystem.dao;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.MovieBookingSystem.beans.ShortUser;
import com.capgemini.MovieBookingSystem.entities.Booking;

@Repository
@EnableScan
public interface BookingDao extends PagingAndSortingRepository<Booking, String> {
	
	List<Booking> findByUser(ShortUser user);
}

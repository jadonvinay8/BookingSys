package com.capgemini.MovieBookingSystem.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.MovieBookingSystem.dao.CustomerDao;
import com.capgemini.MovieBookingSystem.entities.Customer;
import com.capgemini.MovieBookingSystem.exception.CityNotFoundException;

@Service
public class SeatPlanService {

	@Autowired
	private CustomerDao customerDao;

	public Customer addCustomer(Customer city) {
		return customerDao.save(city);
	}

	public Customer findById(String id) {
		return customerDao.findById(id).orElseThrow(CityNotFoundException::new);
	}

	public Customer updateCity(Customer city) {
		findById(city.getUserId()); // if this city didn't exist previously, an exception will be thrown
		return customerDao.save(city);
	}


}

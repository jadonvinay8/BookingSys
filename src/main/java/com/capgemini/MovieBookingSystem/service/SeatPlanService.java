package com.capgemini.MovieBookingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.MovieBookingSystem.dao.SeatPlanDao;
import com.capgemini.MovieBookingSystem.entities.SeatPlan;
import com.capgemini.MovieBookingSystem.exception.CityNotFoundException;

@Service
public class SeatPlanService {

	@Autowired
	private SeatPlanDao seatPlanDao;

	public SeatPlan addCustomer(SeatPlan city) {
		return seatPlanDao.save(city);
	}

	public SeatPlan findById(String id) {
		return seatPlanDao.findById(id).orElseThrow(CityNotFoundException::new);
	}

	public SeatPlan updateCity(SeatPlan city) {
		findById(city.getSeatPlanId()); // if this city didn't exist previously, an exception will be thrown
		return seatPlanDao.save(city);
	}


}

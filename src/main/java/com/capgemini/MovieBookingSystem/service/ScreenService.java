package com.capgemini.MovieBookingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.MovieBookingSystem.dao.ScreenDao;
import com.capgemini.MovieBookingSystem.entities.Screen;
import com.capgemini.MovieBookingSystem.exception.CityNotFoundException;

@Service
public class ScreenService {

	@Autowired
	private ScreenDao screenDao;

	public Screen addCustomer(Screen city) {
		return screenDao.save(city);
	}

	public Screen findById(String id) {
		return screenDao.findById(id).orElseThrow(CityNotFoundException::new);
	}

	public Screen updateCity(Screen city) {
		findById(city.getScreenId()); // if this city didn't exist previously, an exception will be thrown
		return screenDao.save(city);
	}


}

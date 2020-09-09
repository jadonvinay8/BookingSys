package com.capgemini.MovieBookingSystem.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.MovieBookingSystem.dao.UserDao;
import com.capgemini.MovieBookingSystem.entities.User;
import com.capgemini.MovieBookingSystem.exception.CityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	
	public List<User> findAll() {
		return StreamSupport.stream(userDao.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	public User addUser(User user) {
		return userDao.save(user);
	}

	public User findById(String id) {
		return userDao.findById(id).orElseThrow(CityNotFoundException::new);
	}

	public User updateUser(User user) {
		findById(user.getUserId());
		return userDao.save(user);
	}
	
	public User deleteUser(String id) {
		User user=findById(id);
		userDao.delete(user);
		return user;
	}

}

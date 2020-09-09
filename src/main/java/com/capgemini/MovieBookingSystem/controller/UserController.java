package com.capgemini.MovieBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.MovieBookingSystem.entities.User;
import com.capgemini.MovieBookingSystem.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	private DynamoDBMapper dynamoDBMapper;
//  
//	@Autowired
//	private AmazonDynamoDB amazonDynamoDB;
//
//	@PostConstruct
//	public void setup() {
//		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//      CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(User.class);
//      tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L)); 
//      amazonDynamoDB.createTable(tableRequest);
//	}
	
	
	@GetMapping
	public ResponseEntity<List<User>> getAllCities() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User city) {
		return new ResponseEntity<User>(userService.addUser(city), HttpStatus.CREATED);
	}
	
//	@PutMapping
//	public ResponseEntity<City> updateCity(@RequestBody City city) {
//		return new ResponseEntity<City>(locationService.updateCity(city), HttpStatus.OK);
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findCityById(@PathVariable("id") String id) {
		return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
		return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.OK);
	}
	
//	@GetMapping("/{id}/theaters")
//	public ResponseEntity<List<ShortTheater>> getTheaters(@PathVariable("id") String id) {
//		return new ResponseEntity<List<ShortTheater>>(locationService.findById(id).getTheaters(), HttpStatus.OK);		
//	}
//	
//	@PostMapping("/{id}/theaters")
//	public ResponseEntity<Theater> addTheater(@PathVariable("id") String cityId, @RequestBody Theater theater) {
//		return new ResponseEntity<Theater>(theaterService.addTheater(cityId, theater), HttpStatus.CREATED);
//	}
//	
//	@DeleteMapping("/{id}/theaters/{theaterId}")
//	public ResponseEntity<Theater> removeTheater(@PathVariable("id") String cityId, @PathVariable("theaterId") String theaterId) {
//		return new ResponseEntity<Theater>(theaterService.removeTheater(cityId, theaterId), HttpStatus.OK);
//	}
	
}

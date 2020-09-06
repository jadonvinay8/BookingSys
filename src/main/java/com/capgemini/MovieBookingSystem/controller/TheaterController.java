package com.capgemini.MovieBookingSystem.controller;

import java.util.List;

//import javax.annotation.PostConstruct;

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

//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
//import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

import com.capgemini.MovieBookingSystem.beans.ShortMovie;
import com.capgemini.MovieBookingSystem.entities.Movie;
import com.capgemini.MovieBookingSystem.service.MovieService;
import com.capgemini.MovieBookingSystem.service.TheaterService;

/**
 * Controller for handling theater related end-points
 * 
 * @author Vinay Pratap Singh
 *
 */
@RestController
@RequestMapping("/theaters")
public class TheaterController {
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired MovieService movieService;
	
//	private DynamoDBMapper dynamoDBMapper;
//    
//	@Autowired
//	private AmazonDynamoDB amazonDynamoDB;
//
//	@PostConstruct
//	public void setup() {
//		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Movie.class);
//        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L)); 
//        amazonDynamoDB.createTable(tableRequest);
//	}
	
	@GetMapping("/{id}/movies")
	public ResponseEntity<List<ShortMovie>> getMoviesInATheater(@PathVariable("id") String id) {
		return new ResponseEntity<List<ShortMovie>>(theaterService.getMovies(id), HttpStatus.OK);
	}
	
	@PostMapping("/{id}/movies")
	public ResponseEntity<Movie> addMovieInATheater(@PathVariable("id") String id, @RequestBody Movie movie) {
		return new ResponseEntity<Movie>(movieService.addMovie(id, movie), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}/movies/{movieId}")
	public ResponseEntity<Movie> removeMovieInATheater(@PathVariable("id") String theaterId, @PathVariable("movieId") String movieId) {
		return new ResponseEntity<Movie>(movieService.removeMovie(theaterId, movieId), HttpStatus.OK);
	}

}

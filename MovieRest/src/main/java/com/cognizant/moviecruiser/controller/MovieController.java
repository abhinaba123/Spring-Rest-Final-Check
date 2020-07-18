package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController 
{
	private static Logger LOGGER=LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private MovieService movieService;
	 

	@GetMapping()
	public List<Movie> getMovieListCustomer() {
		LOGGER.info("START:MovieController getMovieListCustomer()");
		LOGGER.info("END:MovieController getMovieListCustomer()");
		return movieService.getMovieListCustomer();
	}

	@PutMapping
	public void modifyMovie(@RequestBody Movie movie) throws MovieNotFoundException {
		LOGGER.info("START:MovieController modifyMovie()");
		movieService.modifyMovie(movie);
		LOGGER.info("END:MovieController modifyMovie()");
	}

	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable long movieId) throws MovieNotFoundException {
		LOGGER.info("START:MovieController getMovie()");
		LOGGER.info("END:MovieController getMovie()");
		return movieService.getMovie(movieId);
	}
}

package com.oguzhantasci.studentmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhantasci.studentmanagement.entity.City;
import com.oguzhantasci.studentmanagement.service.ICityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private ICityService cityService;

	@GetMapping("/")
	public ResponseEntity<Iterable<City>> getCities() {
		Iterable<City> response = cityService.getAllCity();
		return new ResponseEntity<Iterable<City>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<City>> getCity(@PathVariable("id") final long id) {
		Optional<City> response = cityService.getCity(id);
		return new ResponseEntity<Optional<City>>(response, HttpStatus.OK);
	}

}

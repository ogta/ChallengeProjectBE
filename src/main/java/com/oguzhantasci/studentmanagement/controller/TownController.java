package com.oguzhantasci.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhantasci.studentmanagement.entity.Town;
import com.oguzhantasci.studentmanagement.service.ITownService;

@RestController
@RequestMapping("/town")
public class TownController {

	@Autowired
	private ITownService townService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Town>> getTowns() {
		Iterable<Town> response = townService.getAllTown();
		return new ResponseEntity<Iterable<Town>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Iterable<Town>> getTownsByCityId(@PathVariable("id") final long id) {
		Iterable<Town> response = townService.findByCity(id);
		return new ResponseEntity<Iterable<Town>>(response, HttpStatus.OK);
	}

}
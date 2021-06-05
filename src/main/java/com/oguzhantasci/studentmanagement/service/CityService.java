package com.oguzhantasci.studentmanagement.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhantasci.studentmanagement.entity.City;
import com.oguzhantasci.studentmanagement.repository.ICityRepository;

@Service
public class CityService implements ICityService {

	@Autowired
	private ICityRepository cityRepository;

	@Override
	public Iterable<City> getAllCity() {
		return cityRepository.findAll();
	}
	
	@Override
	public Optional<City> getCity(Long id) {
		Optional<City> city= cityRepository.findById(id);
		return city;
	}

}

package com.oguzhantasci.studentmanagement.service;

import java.util.Optional;

import com.oguzhantasci.studentmanagement.entity.City;

public interface ICityService {

	Iterable<City> getAllCity();

	Optional<City> getCity(Long id);

}

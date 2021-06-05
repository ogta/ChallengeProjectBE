package com.oguzhantasci.studentmanagement.service;

import com.oguzhantasci.studentmanagement.entity.Town;

public interface ITownService {

	Iterable<Town> getAllTown();
	
	Iterable<Town> findByCity(Long cityId);

}

package com.oguzhantasci.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhantasci.studentmanagement.entity.Town;
import com.oguzhantasci.studentmanagement.repository.ITownRepository;

@Service
public class TownService implements ITownService{

	@Autowired
	private ITownRepository townRepository;

	@Override
	public Iterable<Town> getAllTown() {
		return townRepository.findAll();
	}

	@Override
	public Iterable<Town> findByCity(Long cityId) {
		return townRepository.findByCityId(cityId);
	}

}

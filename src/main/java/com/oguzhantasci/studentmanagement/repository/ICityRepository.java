package com.oguzhantasci.studentmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oguzhantasci.studentmanagement.entity.City;

@Repository
public interface ICityRepository extends CrudRepository<City, Long>{

}

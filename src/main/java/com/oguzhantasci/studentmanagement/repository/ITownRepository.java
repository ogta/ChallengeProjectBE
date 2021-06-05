package com.oguzhantasci.studentmanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oguzhantasci.studentmanagement.entity.Town;

@Repository
public interface ITownRepository extends CrudRepository<Town, Long> {

	@Query("SELECT t FROM Town t WHERE t.city.cityId = :cityId")
	Iterable<Town> findByCityId(Long cityId);

}

package com.oguzhantasci.studentmanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oguzhantasci.studentmanagement.entity.Student;

public interface IStudentRepository extends CrudRepository<Student, Long> {

	Iterable<Student> findByNameContainingIgnoreCase(String name);
	
	@Query("SELECT m FROM Student m WHERE m.city.name LIKE %:name%")
	Iterable<Student> findByCityName(String name);
	
	@Query("SELECT m FROM Student m WHERE m.town.name LIKE %:name%")
	Iterable<Student> findByTownName(String name);
	
	Iterable<Student> findByPhoneNumberContainingIgnoreCase(String phone);
	
	Iterable<Student> findByIdentityNumber(Long identityNumber);
	
}

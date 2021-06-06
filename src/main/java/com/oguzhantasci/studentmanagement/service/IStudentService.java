package com.oguzhantasci.studentmanagement.service;

import java.util.Optional;

import com.oguzhantasci.studentmanagement.entity.Student;
import com.oguzhantasci.studentmanagement.model.RequestCreateStudent;
import com.oguzhantasci.studentmanagement.util.SearchType;

public interface IStudentService {

	Iterable<Student> getStudents();
	
	Optional<Student> getStudent(Long id);

	Student createStudent(RequestCreateStudent createStudentRequest);

	Student updateStudent(RequestCreateStudent createStudentRequest, Long id);

	Iterable<Student> searchStudent(SearchType type, String value);

	void deleteStudent(Long id);

}

package com.oguzhantasci.studentmanagement.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhantasci.studentmanagement.entity.Student;
import com.oguzhantasci.studentmanagement.model.RequestCreateStudent;
import com.oguzhantasci.studentmanagement.service.IStudentService;
import com.oguzhantasci.studentmanagement.util.SearchType;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Student>> getStudents() {
		Iterable<Student> response = studentService.getStudents();
		return new ResponseEntity<Iterable<Student>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable("id") final long id) {
		Optional<Student> response = studentService.getStudent(id);
		if (response.isPresent()) {
			return new ResponseEntity<Optional<Student>>(response, HttpStatus.OK);
		}
		
		return new ResponseEntity<Optional<Student>>(HttpStatus.NO_CONTENT);
		
	}

	@PostMapping("/")
	public ResponseEntity<Student> addCustomer(@RequestBody RequestCreateStudent student) {
		return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateCustomer(@PathVariable("id") final long id, @RequestBody RequestCreateStudent student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.CREATED);
	}

	@GetMapping("/search/{type}/{value}")
	public ResponseEntity<Iterable<Student>> searchStudent(@PathVariable("type") SearchType type,
			@PathVariable("value") String value) {
		Iterable<Student> response = studentService.searchStudent(type, value);

		if (CollectionUtils.isEmpty((Collection<?>) response)) {
			return new ResponseEntity<Iterable<Student>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Iterable<Student>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") final Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

}

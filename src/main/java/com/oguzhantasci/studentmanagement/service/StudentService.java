package com.oguzhantasci.studentmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.oguzhantasci.studentmanagement.entity.City;
import com.oguzhantasci.studentmanagement.entity.Student;
import com.oguzhantasci.studentmanagement.entity.Town;
import com.oguzhantasci.studentmanagement.model.RequestCreateStudent;
import com.oguzhantasci.studentmanagement.repository.ICityRepository;
import com.oguzhantasci.studentmanagement.repository.IStudentRepository;
import com.oguzhantasci.studentmanagement.repository.ITownRepository;
import com.oguzhantasci.studentmanagement.util.SearchType;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;

	@Autowired
	private ITownRepository townRepository;

	@Autowired
	private ICityRepository cityRepository;

	@Override
	public Iterable<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudent(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public Student createStudent(RequestCreateStudent createStudentRequest) {

		Student student = mapRequestToEntity(createStudentRequest);
		System.out.println(createStudentRequest.getCityId());
		System.out.println(createStudentRequest.getTownId());
		
		Optional<Town> town = townRepository.findById(createStudentRequest.getTownId());
		Optional<City> city = cityRepository.findById(createStudentRequest.getCityId());

		student.setCity(city.get());
		student.setTown(town.get());

		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(RequestCreateStudent createStudentRequest, Long id) {

		Student student = studentRepository.findById(id).get();

		if (createStudentRequest.getCityId() != null
				&& !student.getCity().getCityId().equals(createStudentRequest.getCityId())) {
			Optional<City> city = cityRepository.findById(createStudentRequest.getCityId());
			student.setCity(city.get());
		}

		if (createStudentRequest.getTownId() != null
				&& !student.getTown().getTownId().equals(createStudentRequest.getTownId())) {
			Optional<Town> town = townRepository.findById(createStudentRequest.getTownId());
			student.setTown(town.get());
		}

		if (StringUtils.hasText(createStudentRequest.getName())) {
			student.setName(createStudentRequest.getName());
		}

		if (StringUtils.hasText(createStudentRequest.getPhoneNumber())) {
			student.setPhoneNumber(createStudentRequest.getPhoneNumber());
		}

		if (createStudentRequest.getIdentityNumber() != null) {
			student.setIdentityNumber(createStudentRequest.getIdentityNumber());
		}

		return studentRepository.save(student);
	}

	private Student mapRequestToEntity(RequestCreateStudent createStudentRequest) {

		Student student = new Student();
		student.setIdentityNumber(createStudentRequest.getIdentityNumber());
		student.setName(createStudentRequest.getName());
		student.setPhoneNumber(createStudentRequest.getPhoneNumber());
		return student;

	}

	@Override
	public Iterable<Student> searchStudent(SearchType type, String value) {

		if (type.equals(SearchType.IDENTITY_NUMBER)) {
			return studentRepository.findByIdentityNumber(Long.valueOf(value));
		} else if (type.equals(SearchType.CITY)) {
			return studentRepository.findByCityName(value);
		} else if (type.equals(SearchType.TOWN)) {
			return studentRepository.findByTownName(value);
		} else if (type.equals(SearchType.PHONE)) {
			return studentRepository.findByPhoneNumberContainingIgnoreCase(value);
		} else if (type.equals(SearchType.NAME)) {
			return studentRepository.findByNameContainingIgnoreCase(value);
		}

		return null;
	}
	
	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

}

package com.hongzhou.university.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hongzhou.university.domain.Person;
import com.hongzhou.university.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	// simply query methods
	List<Student> findByFullTime(boolean fullTime);
	List<Student> findByAge(Integer age);
	List<Student> findByAttendeeLastName(String lastName);
	
	// query methods with clauses and expressions
	Student findByAttendeeFirstNameAndAttendeeLastName(String firstName, String lastName);
	Student findByAttendee(Person person);
	List<Student> findByAgeGreaterThan(int minimumAge);
	List<Student> findByAgeLessThan(int maximumAge);
	List<Student> findByAttendeeLastNameIgnoreCase(String lastName);
	List<Student> findByAttendeeLastNameLike(String likeString);
	Student findFirstByOrderByAttendeeLastNameAsc();
	Student findTopByOrderByAgeDesc();
	List<Student> findTop3ByOrderByAgeDesc();
	
}

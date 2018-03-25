package com.hongzhou.university;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.hongzhou.university.domain.Course;
import com.hongzhou.university.domain.Department;
import com.hongzhou.university.domain.Person;
import com.hongzhou.university.domain.Staff;
import com.hongzhou.university.repo.CourseRepository;
import com.hongzhou.university.repo.DepartmentRepository;
import com.hongzhou.university.repo.StaffRepository;
import com.hongzhou.university.repo.StudentRepository;


/*
 * Data persisted to H2 in-Memory database at startup.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryTest {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	public void simpleQueryTest() {
		System.out.println("\nFind 20 year old students");
		studentRepository.findByAge(20).forEach(System.out::println);
		
		System.out.println("\nFind full time  students");
		studentRepository.findByFullTime(true).forEach(System.out::println);
		
		System.out.println("\nFind students with 'doe' as last name");
		studentRepository.findByAttendeeLastName("doe").forEach(System.out::println);
	}
	
	@Test
	public void intermediateQueryTest() {
		System.out.println("Find student by name and traverse entities \n" +
				studentRepository.findByAttendeeFirstNameAndAttendeeLastName("jane", "doe"));
		System.out.println("Find students by name with Person object \n" +
				studentRepository.findByAttendee(new Person("jane", "doe")));
		System.out.println("\nFind students older that 19");
		studentRepository.findByAgeGreaterThan(19).forEach(System.out::println);
		
		System.out.println("\nFind students younger that 19");
		studentRepository.findByAgeLessThan(19).forEach(System.out::println);
		
		System.out.println("\nFind students with last name Doe, despite the case");
		studentRepository.findByAttendeeLastNameIgnoreCase("Doe").forEach(System.out::println);
		
		System.out.println("\nFind Students with an i in the last name");
		studentRepository.findByAttendeeLastNameLike("%i%").forEach(System.out::println);
		
		System.out.println("\nFind first Student in alphabet \n" + 
				studentRepository.findFirstByOrderByAttendeeLastNameAsc());
		
		System.out.println("\nFind oldest Student \n" + 
				studentRepository.findTopByOrderByAgeDesc());
		
		System.out.println("\nFind 3 oldest student \n" + 
				studentRepository.findTop3ByOrderByAgeDesc());
	}
	
	@Test
	public void jPQLQueriesTest() {
		System.out.println("Find Courses where Jones is the department Chair with Property Expression");
		courseRepository.findByDepartmentChairMemberLastName("Jones").forEach(System.out::println);
		
		System.out.println("\nFind Course where Jones is the department Chair with @Query");
		courseRepository.findByChairLastName("Jones").forEach(System.out::println);
		
		Course english101 = courseRepository.findByName("English 101");
		System.out.println("\nFind courses where English 101 is a prerequisite");
		courseRepository.findCourseByPrerequisite(english101.getId()).forEach(System.out::println);
		
		System.out.println("\nCoureseView for English 101 \n" + 
				courseRepository.getCourseView(english101.getId()));
	}
	
	@Test
	public void pagingAndSortingQueries() {
		System.out.println("\nFind all 3-credit courses");
		courseRepository.findByCredits(3).forEach(System.out::println);
		
		System.out.println("\nFind first 4 3-credit courses, sort by credit, then course name");
		Page<Course> courses = courseRepository.findByCredits(3, new PageRequest(0, 4, Sort.Direction.ASC, "credits", "name"));
		courses.forEach(System.out::println);
		
		System.out.println("\nFind all staff members, sort alphabetically by last name");
		Sort sortByLastName = new Sort(Sort.Direction.ASC, "member.lastName");
		staffRepository.findAll(sortByLastName).forEach(System.out::println);
		
		Page<Staff> members = staffRepository.findAll(new PageRequest(0, 5, sortByLastName));
		System.out.println("\nTotal number of staff members=" + members.getTotalElements());
		System.out.println("Total number of 5-element-pages= " + members.getTotalPages());
		System.out.println("find first 5 staff members, sort alphabetically by last name");
		members.forEach(System.out::println);
	}
	
	/**
	 * Queries using Query by Example
	 */
	@Test
	public void queryByExampleTest() {
		System.out.println("\nFind the Department with the name 'Humanities' \n" + 
				departmentRepository.findOne(Example.of(new Department("Humanities", null))));
		
		System.out.println("\nFind Departments with the first name of the chair is 'John' ");
		departmentRepository.findAll(Example.of(new Department(null, new Staff(new Person("John", null))))).forEach(System.out::println);
		
		System.out.println("\nFind All Department with the name ending in 'Science', case insensitive");
		departmentRepository.findAll(Example.of(new Department("science", null),
				ExampleMatcher.matching().
					withIgnoreCase().
					withStringMatcher(ExampleMatcher.StringMatcher.ENDING))).forEach(System.out::println);
	}
}

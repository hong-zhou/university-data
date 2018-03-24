package com.hongzhou.university;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hongzhou.university.domain.Person;
import com.hongzhou.university.domain.Student;
import com.hongzhou.university.repo.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

	/**
	 * Exercise CrudRepository methods
	 */
	@Test
	public void simpleStudentCrudTest() {
		boolean fullTime = true;
		studentRepository.save(new Student(new Person("Hong", "Zhou"), fullTime, 25));
		studentRepository.save(new Student(new Person("Yong", "Zhou"), fullTime, 23));
		studentRepository.save(new Student(new Person("Qiang", "Xiao"), fullTime, 20));
		studentRepository.save(new Student(new Person("An", "He"), fullTime, 18));

		System.out.println("\n**********************Original Students*********************");
		studentRepository.findAll().forEach(System.out::println);

		// age up the students
		studentRepository.findAll().forEach(student -> {
			student.setAge(student.getAge() + 1);
			studentRepository.save(student);
		});

		System.out.println("\n**********************Student a year older*********************");
		studentRepository.findAll().forEach(System.out::println);
		
		studentRepository.deleteAll();
		
		System.out.println("\n**********************Student deletedr*********************");		
		studentRepository.findAll().forEach(System.out::println);
	}
}

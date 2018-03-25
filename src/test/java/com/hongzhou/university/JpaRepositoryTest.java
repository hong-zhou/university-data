package com.hongzhou.university;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hongzhou.university.domain.Department;
import com.hongzhou.university.repo.DepartmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	/**
	 * Exercise JPA Repository methods
	 */
/*	@Test
	public void testJpaRepositoryMethods() {
		departmentRepository.save(new Department("Biology"));
		departmentRepository.flush();
		
		departmentRepository.saveAndFlush(new Department("Computer Science"));
		
		departmentRepository.save(new Department("Social Science"));
		System.out.println("\n****************3 Departments*********");
		departmentRepository.findAll().forEach(System.out::println);
		
		departmentRepository.deleteInBatch(departmentRepository.findAll().subList(0, 1));
		
		System.out.println("\n****************1 Less Departments*********");
		departmentRepository.findAll().forEach(System.out::println);
		
		departmentRepository.deleteAllInBatch();
		System.out.println("\n****************no Departments*********");
		departmentRepository.findAll().forEach(System.out::println);
	}
	
	@Before
	@After
	public void banner() {
		System.out.println("\n\n********************************************************************************\n");
	}*/
}

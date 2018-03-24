package com.hongzhou.university.repo;

import org.springframework.data.repository.CrudRepository;

import com.hongzhou.university.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}

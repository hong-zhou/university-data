package com.hongzhou.university.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hongzhou.university.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}

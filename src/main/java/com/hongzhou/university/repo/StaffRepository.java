package com.hongzhou.university.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hongzhou.university.domain.Staff;

public interface StaffRepository extends PagingAndSortingRepository<Staff, Integer> {

}

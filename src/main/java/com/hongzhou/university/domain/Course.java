package com.hongzhou.university.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn
	private Department department;
	
	protected Course() {}

	public Course(String name, Department department) {
		super();
		this.name = name;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

}

package com.hongzhou.university.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	//@JoinColumn
	private Department department;

	@Column
	private Integer credits;

	@OneToOne
	private Staff instructor;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Course> prerequisites = new ArrayList<>();

	protected Course() {
	}

	public Course(String name, Integer credits, Staff instructor, Department department) {
		super();
		this.name = name;
		this.credits = credits;
		this.instructor = instructor;
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

	public Integer getCredits() {
		return credits;
	}

	public Staff getInstructor() {
		return instructor;
	}

	public Course addPrerequisite(Course prerequisite) {
		prerequisites.add(prerequisite);
		return this;
	}

	@Override
	public String toString() {
		return "Course{" + "name='" + name + '\'' + ", id=" + id + ", credits=" + credits + ", instructor=" + instructor
				+ ", department=" + department.getName() + '}';
	}

}

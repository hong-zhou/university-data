package com.hongzhou.university.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Department")
public class Department {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
	
	protected Department() {}
	
	public Department(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", courses=" + courses + "]";
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void addCourses(Course course) {
		courses.add(course);
	}
	

}

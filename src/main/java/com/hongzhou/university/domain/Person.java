package com.hongzhou.university.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Person {
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	protected Person() {
		
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}

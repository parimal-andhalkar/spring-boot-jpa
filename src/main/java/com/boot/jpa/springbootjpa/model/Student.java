package com.boot.jpa.springbootjpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int rollNo;
	private String firstName;
	private String lastName;
	
	public Student() {}
	
	
	
	
	public Student(int rollNo, String firstName, String lastName) {
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	

}

package com.javatechie.crud.example.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

import com.javatechie.crud.example.enumeration.Gender;
import com.javatechie.crud.example.enumeration.Status;

@Entity
@Table(name = "PERSON_TbL")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "LAST_NAME")
	private String lastname;
	
	@Column(name = "FIRST_NAME")
	private String firstname;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "NUMBER_OF_BOOK")
	private int numberofbook;
	
	
	@Column(name = "DEGREE")
	private String degree;
	@Column(name = "AGE")
	private int age;
	@Column(name = "SALARY")
	private BigDecimal salary;
	@Column(name = "GENDER")
	private Gender gender;
	@Column(name = "STATUS")
	private Status status;
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLastname() {
		return lastname;
	}

	

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberofbook() {
		return numberofbook;
	}

	public void setNumberofbook(int numberofbook) {
		this.numberofbook = numberofbook;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

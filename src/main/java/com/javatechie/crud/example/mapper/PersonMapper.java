package com.javatechie.crud.example.mapper;

import java.math.BigDecimal;
//import java.util.Optional;
//import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

//import org.springframework.beans.factory.annotation.Autowired;

import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Gender;
import com.javatechie.crud.example.enumeration.Status;
import com.javatechie.crud.example.model.PersonView;


@Component
public class PersonMapper {

	public Person modelToEntity(PersonView personView) {
		Person person1 = new Person();

		person1.setId(Integer.parseInt(personView.getId()));
		person1.setFirstname(personView.getFirstname());
		person1.setLastname(personView.getLastname());
		person1.setAge(Integer.parseInt(personView.getAge()));
		person1.setLocation(personView.getLocation());
		person1.setDegree(personView.getDegree());
		person1.setNumberofbook(Integer.parseInt(personView.getNumberofbook()));
		person1.setSalary(new BigDecimal(personView.getSalary()));
		person1.setGender(Gender.valueOf(personView.getGender()));
		person1.setStatus(Status.valueOf(personView.getStatus()));
		return person1;

	}

	public PersonView entityToModel(Person person) {
		PersonView personview1 = new PersonView();
		personview1.setId(String.valueOf(person.getId()));
		personview1.setFirstname(person.getFirstname());
		personview1.setLastname(person.getLastname());
		personview1.setAge(String.valueOf(person.getAge()));
		personview1.setLocation(person.getLocation());
		personview1.setNumberofbook(String.valueOf(person.getNumberofbook()));
		personview1.setSalary(person.getSalary().toString());
		personview1.setGender(person.getGender().toString());
		personview1.setDegree(person.getDegree());
		personview1.setStatus(person.getStatus().toString());
		return personview1;
	}
}
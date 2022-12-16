package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Person;
//import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.mapper.PersonMapper;
import com.javatechie.crud.example.model.PersonView;
//import com.javatechie.crud.example.model.PersonView;
//import com.javatechie.crud.example.model.PersonView;
import com.javatechie.crud.example.repository.PersonRespository;

import java.math.BigDecimal;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	private PersonRespository repository;
	@Autowired
	private PersonMapper personMapper;

	public Person savePersonView(PersonView personview) {

		return repository.save(personMapper.modelToEntity(personview));

	}

	public Person updatePerson(PersonView personview) {
		 Person person = repository.findById(Long.valueOf(personview.getId())).orElse(null);
		   person.setFirstname(personview.getFirstname());
			person.setLastname(personview.getLastname());
			person.setAge(Integer.parseInt(personview.getAge()));
			person.setSalary(new BigDecimal(personview.getSalary()));
			person.setLocation(personview.getLocation());
			return repository.save(person);


	    }

		

	

	public PersonView getPersonByid(int id) {
	Person person =	 repository.findById(Long.valueOf(id)).orElse(null);
   PersonView personview=  personMapper.entityToModel(person);

		return personview;
	}

	public void deletePerson(int id) {
		repository.deleteById(Long.valueOf(id));

	}

}

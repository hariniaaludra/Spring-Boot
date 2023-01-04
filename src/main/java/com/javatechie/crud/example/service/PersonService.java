package com.javatechie.crud.example.service;

import java.math.BigDecimal;
//import java.util.Optional;
import java.util.Optional;

//import com.javatechie.crud.example.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Book;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Available;
import com.javatechie.crud.example.mapper.BookMapper;
import com.javatechie.crud.example.model.BookView;
import com.javatechie.crud.example.repository.BookRespository;
import com.javatechie.crud.example.repository.PersonRespository;

import validation.DataNotFoundException;
import validation.DublicateDataNotFoundException;
//import validation.InvalidException;
import validation.Validator;

@Service
public class PersonService {

	@Autowired
	BookRespository bookrepository;
	@Autowired
	PersonRespository personrepository;
	@Autowired
	BookMapper bookMapper;
	Validator validate = new Validator();

	public Book saveBookView(BookView bookview) throws DublicateDataNotFoundException {

		if (bookrepository.existsByCode(bookview.getCode())) {
			return bookrepository.save(bookMapper.entityToModel(bookview));
		} else {

			throw new DublicateDataNotFoundException("code is already exists");
		}
	}

	public ResponseEntity<?> savePersonView(BookView bookview) {

		Person person = bookMapper.modelToEntity(bookview);

		Person person1 = personrepository.save(person);
		return ResponseEntity.status(HttpStatus.OK).body(person1);

	}

	public Person updatePerson(BookView bookview) {

		Person person = personrepository.findById(Long.valueOf(bookview.getId())).orElse(null);
		person.setLastname(bookview.getLastname());
		person.setAge(Integer.parseInt(bookview.getAge()));
		person.setSalary(new BigDecimal(bookview.getSalary()));
		return personrepository.save(person);
	}

	public Book updateBookView(BookView bookview) {

		Book book = bookrepository.findById(Long.valueOf(bookview.getId())).orElse(null);
		book.setName(bookview.getName());
		book.setStock(Integer.parseInt(bookview.getStock()));
		book.setAvailable(Available.valueOf(bookview.getAvailable()));
		return bookrepository.save(book);

	}

	public Optional<Person> getPersonByid(int id) throws DataNotFoundException {
		Optional<Person> optperson = personrepository.findById(Long.valueOf(id));
		validate.validato(optperson);
		return optperson;

	}

	public Book getBookByid(int id) {

		return bookrepository.findById(Long.valueOf(id)).orElse(null);

	}
//
//	public void deletePerson(int id) {
//		repository.deleteById(Long.valueOf(id));
//
//	}

}

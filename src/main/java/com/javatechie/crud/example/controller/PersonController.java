package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Book;

import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.model.BookView;

import com.javatechie.crud.example.service.PersonService;

import validation.DataNotFoundException;
import validation.DublicateDataNotFoundException;
import validation.InvalidException;

import validation.Validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

	Validator validator1 = new Validator();

	@Autowired
	private PersonService service;

	@PostMapping("/addperson")
	public ResponseEntity<?> addPerson(@RequestBody BookView bookview) throws InvalidException {
		try {

			validator1.validate(bookview);

			return ResponseEntity.status(HttpStatus.OK).body(service.savePersonView(bookview));
		} catch (InvalidException a) {
			return new ResponseEntity<>(a.getmessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addbook")
	public ResponseEntity<?> addBook(@RequestBody BookView bookview) throws DublicateDataNotFoundException {
		try {

			return ResponseEntity.status(HttpStatus.OK).body(service.saveBookView(bookview));
		} catch (DublicateDataNotFoundException a) {
			return new ResponseEntity<>(a.getmessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> personData(@RequestBody BookView bookview) throws InvalidException {
		try {

			validator1.validate(bookview);

			return ResponseEntity.status(HttpStatus.OK).body(service.updatePerson(bookview));
		} catch (InvalidException a) {
			return new ResponseEntity<>(a.getmessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updatebook")
	public Book bookData(@RequestBody BookView bookview) {
		return service.updateBookView(bookview);
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<?> findPersonById(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getPersonByid(id));
		} catch (DataNotFoundException a) {
			return new ResponseEntity<>(a.getmessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/book/{id}")
	public Book findBookId(@PathVariable int id) {
		return service.getBookByid(id);
	}
}

//	@DeleteMapping("/delete/{id}")
//	public void person(@PathVariable int id) {
//		service.deletePerson(id);
//	}
//
//}

package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Book;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.model.BookView;


import com.javatechie.crud.example.service.PersonService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping("/addperson")
	public Person addPerson(@RequestBody BookView bookview) {
		return service.savePersonView(bookview);
	}

	@PostMapping("/addbook")
	public Book addBook(@RequestBody BookView bookview) {
		return service.saveBookView(bookview);
	}

	@PutMapping("/update")
	public Person personData(@RequestBody BookView bookview) {
		return service.updatePerson(bookview);
	}

	@PutMapping("/updatebook")
	public Book bookData(@RequestBody BookView bookview) {
		return service.updateBookView(bookview);
	}

	@GetMapping("/person/{id}")
    public Person findPersonById(@PathVariable int id) {
		return service.getPersonByid(id);
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

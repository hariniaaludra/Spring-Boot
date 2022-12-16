package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.model.PersonView;
import com.javatechie.crud.example.service.PersonService;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping("/addperson")
	public Person addPerson(@RequestBody PersonView personview) {
		return service.savePersonView(personview);
	}

	@PutMapping("/update")
	public Person persondata(@RequestBody PersonView personview) {
		return service.updatePerson(personview);
	}

	@GetMapping("/person/{id}")
	public PersonView findPersonByName(@PathVariable int id) {
		return service.getPersonByid(id);
	}

	@DeleteMapping("/delete/{id}")
	public void person(@PathVariable int id) {
		service.deletePerson(id);
	}

}

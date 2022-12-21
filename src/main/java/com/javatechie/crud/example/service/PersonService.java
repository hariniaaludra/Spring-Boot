package com.javatechie.crud.example.service;

import java.math.BigDecimal;
//import java.util.Optional;

//import com.javatechie.crud.example.entity.Person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Book;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Available;
import com.javatechie.crud.example.mapper.BookMapper;
import com.javatechie.crud.example.model.BookView;
import com.javatechie.crud.example.repository.BookRespository;
import com.javatechie.crud.example.repository.PersonRespository;


@Service
public class PersonService {
	@Autowired
	private BookRespository bookrepository;
	@Autowired
	private PersonRespository personrepository;
	@Autowired
	private BookMapper bookMapper;

	public Book saveBookView(BookView bookview) {

		return bookrepository.save(bookMapper.entityToModel(bookview));

	}
	public Person savePersonView(BookView bookview) {

		return personrepository.save(bookMapper.modelToEntity(bookview));

	}
	

	public Person updatePerson(BookView bookview) {
		Person person = personrepository.findById(Long.valueOf(bookview.getId())).orElse(null);
			person.setLastname(bookview.getLastname());
			person.setAge(Integer.parseInt(bookview.getAge()));
			person.setSalary(new BigDecimal(bookview.getSalary()));
			return personrepository.save(person);
		   }

	public Book updateBookView(BookView bookview)	{
	
		 Book book= bookrepository.findById(Long.valueOf(bookview.getId())).orElse(null);
		   book.setName(bookview.getName());
			book.setStock(Integer.parseInt(bookview.getStock()));
			book.setAvailable(Available.valueOf(bookview.getAvailable()));
			return bookrepository.save(book);
		
	}

	

	public Person getPersonByid(int id) {
     return  personrepository.findById(Long.valueOf(id)).orElse(null);
       
   }
	public Book getBookByid(int id) {
	     return  bookrepository.findById(Long.valueOf(id)).orElse(null);
	       
	}
//
//	public void deletePerson(int id) {
//		repository.deleteById(Long.valueOf(id));
//
//	}

}

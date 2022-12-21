package com.javatechie.crud.example.mapper;

import java.math.BigDecimal;


import org.springframework.stereotype.Component;

import com.javatechie.crud.example.entity.Book;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Available;
import com.javatechie.crud.example.enumeration.Gender;
import com.javatechie.crud.example.enumeration.Status;
import com.javatechie.crud.example.model.BookView;
@Component
public class BookMapper {

	public Person modelToEntity(BookView bookview) {

		Person person1 = new Person();

		person1.setFirstname(bookview.getFirstname());
		person1.setLastname(bookview.getLastname());
		person1.setAge(Integer.valueOf(bookview.getAge()));
		person1.setLocation(bookview.getLocation());
		person1.setDegree(bookview.getDegree());
		person1.setNumberofbook(Integer.valueOf(bookview.getNumberofbook()));
		person1.setSalary(new BigDecimal(bookview.getSalary()));
		person1.setGender(Gender.valueOf(bookview.getGender()));
		person1.setStatus(Status.valueOf(bookview.getStatus()));
		return person1;
	}

	public Book entityToModel(BookView bookview) {
		Book book = new Book();
		
		book.setName(bookview.getName());
		book.setAuthor(modelToEntity(bookview));
		book.setPublishon(Integer.parseInt(bookview.getPublishon()));
		book.setStock(Integer.parseInt(bookview.getStock()));
		book.setAvailable(Available.valueOf(bookview.getAvailable()));
		return book;

	}
}
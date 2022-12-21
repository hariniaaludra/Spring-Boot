package com.javatechie.crud.example.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.crud.example.controller.PersonController;
import com.javatechie.crud.example.entity.Book;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Available;
import com.javatechie.crud.example.enumeration.Gender;
import com.javatechie.crud.example.enumeration.Status;

import com.javatechie.crud.example.model.BookView;
import com.javatechie.crud.example.service.PersonService;

@RunWith(SpringRunner.class)
public class PersonControllerTest {

	@InjectMocks
	PersonController personcontroller;

	@Mock
	PersonService service;

	BookView bookView = new BookView();
	Person person = new Person();
	Book book = new Book();

	@Before
	public void rest() {

		bookView.setId("1");
		bookView.setLastname("G");
		bookView.setName("darker");
		bookView.setAge("23");
		bookView.setSalary("10000");
		bookView.setFirstname("Prakash");
		bookView.setLocation("namakkal");
		bookView.setDegree("be");
		bookView.setNumberofbook("2");
		bookView.setGender(Gender.MALE.toString());
		bookView.setStatus(Status.ACTIVE.toString());
		bookView.setPublishon("2026");
		bookView.setStock("100");
		bookView.setAvailable("YES");
		person.setId(1);
		person.setLastname("G");
		person.setAge(23);
		person.setSalary(BigDecimal.valueOf(10000));
		person.setFirstname("Prakash");
		person.setLocation("namakkal");
		person.setDegree("be");
		person.setNumberofbook(2);
		person.setGender(Gender.MALE);
		person.setStatus(Status.ACTIVE);
		book.setName("raman");
		book.setId(1);
		book.setAvailable(Available.valueOf("YES"));
		book.setPublishon(2026);
		book.setStock(4);
	}

	@Test
	public void addPersonTest() {
		
		when( service.savePersonView(bookView)).thenReturn(person);

		assertEquals(person.getDegree(), personcontroller.addPerson(bookView).getDegree());
		
	}
	@Test
	public void saveBookViewTest() {
		
		when( service.saveBookView(bookView)).thenReturn(book);

		assertEquals(book.getAvailable(), personcontroller.addBook(bookView).getAvailable());
		
	}
	@Test
	public void addDataTest() {
		
		when( service.updatePerson(bookView)).thenReturn(person);

		assertEquals(person.getFirstname(), personcontroller.personData(bookView).getFirstname());
		
	}
	@Test
	public void updateBookTest() {
		
		when( service.updateBookView(bookView)).thenReturn(book);

		assertEquals(book.getName(), personcontroller.bookData(bookView).getName());
		
	}
	
	@Test
	public void findPersonByIdTest() {
		
		when( service.getPersonByid(Integer.valueOf(bookView.getId()))).thenReturn(person);

		assertEquals(person.getId(), personcontroller.findPersonById(1).getId());
		
	}
	@Test
	public void findBookIdTest() {
		
		when( service.getBookByid(Integer.valueOf(bookView.getId()))).thenReturn(book);

		assertEquals(book.getId(), personcontroller.findBookId(1).getId());
		
	}
}
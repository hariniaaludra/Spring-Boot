package com.javatechie.crud.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.crud.example.entity.Book;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Gender;
import com.javatechie.crud.example.enumeration.Status;
import com.javatechie.crud.example.mapper.BookMapper;
import com.javatechie.crud.example.model.BookView;

@RunWith(SpringRunner.class)
public class BookMapperTest {

	@InjectMocks
	BookMapper bookmapper;

	BookView bookView = new BookView();

	@Before
	public void test() {

		bookView.setLastname("G");
		bookView.setName("prakash");
		bookView.setAge("22");
		bookView.setSalary("20000");
		bookView.setFirstname("Prakash");
		bookView.setLocation("trichy");
		bookView.setDegree("be");
		bookView.setNumberofbook("4");
		bookView.setGender(Gender.MALE.toString());
		bookView.setStatus(Status.ACTIVE.toString());
		bookView.setPublishon("2022");
		bookView.setStock("2");
		bookView.setAvailable("YES");

	}

	@Test

	public void entityToModelTest() {

		String data = bookView.getName();
		Book view = bookmapper.entityToModel(bookView);
		assertEquals(view.getName(), data);
	}

	@Test
	public void modelToEntity() {

		int age = Integer.valueOf(bookView.getAge());
		Person book = bookmapper.modelToEntity(bookView);
		assertEquals(book.getAge(), age);

	}
}

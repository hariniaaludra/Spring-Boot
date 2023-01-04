package com.javatechie.crud.example.test;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.crud.example.entity.Book;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Available;
import com.javatechie.crud.example.enumeration.Gender;
import com.javatechie.crud.example.enumeration.Status;
import com.javatechie.crud.example.mapper.BookMapper;
import com.javatechie.crud.example.model.BookView;
import com.javatechie.crud.example.repository.BookRespository;
import com.javatechie.crud.example.repository.PersonRespository;
import com.javatechie.crud.example.service.PersonService;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class PersonServiceTest {

	@InjectMocks
	PersonService personService;

	@Mock
	PersonRespository personRespository;
	@Mock
	BookRespository bookrepository;
	@Mock
	BookMapper bookMapper;

	BookView bookView = new BookView();
	Person person = new Person();
	Book book = new Book();

	@BeforeEach	
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
	 void updatePersonTest() {
		// when(personRespository.findById(Long.valueOf(bookView.getId()))).thenReturn(Optional.of(person));
		doReturn(Optional.of(person)).when(personRespository).findById(Long.valueOf(bookView.getId()));
		// when(personRespository.save(person)).thenReturn(person);
		doReturn(person).when(personRespository).save(person);
		Person aer = personService.updatePerson(bookView);
		String cer = bookView.getDegree();
		assertEquals(aer.getDegree(), cer);

	}

	
// void savePersonViewTest() throws InvalidFirstNameException {
//
////		when(personRespository.save(bookMapper.modelToEntity(bookView))).thenReturn(person);
//		doReturn(person).when(personRespository).save(Mockito.any());
////		
////	    when(bookMapper.modelToEntity(bookView)).thenReturn(person);
////	    doReturn(person).when(personRespository).save(person);
//		
//		Person ber = personService.savePersonView(bookView);
//		assertEquals(ber.getFirstname(), person.getFirstname());
//	}

//	@Test
//	 void saveBookViewTest()  {
//
//       when(bookMapper.entityToModel(bookView)).thenReturn(book);
//		
//		doReturn(book).when(bookrepository).save(book);
//		Book csr = personService.saveBookView(bookView);
//		assertEquals(csr.getStock(), book.getStock());
//	}

	@Test
 void updateBookTest() {
		// when(bookrepository.findById(Long.valueOf(bookView.getId()))).thenReturn(Optional.of(book));
		doReturn(Optional.of(book)).when(bookrepository).findById(Long.valueOf(bookView.getId()));
		//when(bookrepository.save(book)).thenReturn(book);
		doReturn(book).when(bookrepository).save(book);
		Book ser = personService.updateBookView(bookView);
		assertEquals(ser.getName(), book.getName());
	}

//	@Test
//	 void getPersonByidTest() {
//
//		// when(personRespository.findById(Long.valueOf(bookView.getId()))).thenReturn(Optional.of(person));
//		doReturn(Optional.of(person)).when(personRespository).findById(Long.valueOf(bookView.getId()));
//		// when(personRespository.save(person)).thenReturn(person);
//	///	doReturn(person).when(personRespository).save(person);
//
//		Person fer = personService.getPersonByid(1);
//		assertEquals(fer.getId(), person.getId());
//
//	}

	@Test
	 void getBookByidTest() {

		//when(bookrepository.findById(Long.valueOf(bookView.getId()))).thenReturn(Optional.of(book));
		 doReturn(Optional.of(book)).when(bookrepository).findById(Long.valueOf(bookView.getId()));
		//when(bookrepository.save(book)).thenReturn(book);
		// doReturn(book).when(bookrepository).save(book);

		Book ver = personService.getBookByid(1);
		assertEquals(ver.getId(), person.getId());

	}

}

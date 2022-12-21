package com.javatechie.crud.example.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

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

@RunWith(SpringRunner.class)
public class PersonServiceTest {

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
	public void updatePersonTest() {
		when(personRespository.findById(Long.valueOf(bookView.getId()))).thenReturn(Optional.of(person));
		when(personRespository.save(person)).thenReturn(person);
		Person aer = personService.updatePerson(bookView);
		String cer = bookView.getDegree();
		assertEquals(aer.getDegree(), cer);

	}

	@Test
	public void savePersonViewTest() {

		when(personRespository.save(bookMapper.modelToEntity(bookView))).thenReturn(person);
		Person ber = personService.savePersonView(bookView);
		assertEquals(ber.getFirstname(), person.getFirstname());
	}

	@Test
	public void saveBookViewTest() {

		when(bookrepository.save(bookMapper.entityToModel(bookView))).thenReturn(book);
		Book csr = personService.saveBookView(bookView);
		assertEquals(csr.getStock(),book.getStock());
	}
    @Test
    public void updateBookTest() {
    	when(bookrepository.findById(Long.valueOf(bookView.getId()))).thenReturn(Optional.of(book));
    	when(bookrepository.save(book)).thenReturn(book);
    	Book ser=personService.updateBookView(bookView);
    	assertEquals(ser.getName(),book.getName());
    }
    @Test
    public void getPersonByidTest() {
    	
    	when(personRespository.findById(Long.valueOf(bookView.getId()))).thenReturn(Optional.of(person));
		when(personRespository.save(person)).thenReturn(person);
		Person fer=personService.getPersonByid(1);
		assertEquals(fer.getId(),person.getId());
		
    }
    @Test
    public void getBookByidTest() {
    	
    	when(bookrepository.findById(Long.valueOf(bookView.getId()))).thenReturn(Optional.of(book));
		when(bookrepository.save(book)).thenReturn(book);
		Book ver=personService.getBookByid(1);
		assertEquals(ver.getId(),person.getId());
		
    }
    
}

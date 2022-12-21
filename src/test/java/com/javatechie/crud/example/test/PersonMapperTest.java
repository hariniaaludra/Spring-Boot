package com.javatechie.crud.example.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;


import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Gender;
import com.javatechie.crud.example.enumeration.Status;
import com.javatechie.crud.example.mapper.PersonMapper;
import com.javatechie.crud.example.model.PersonView;

@RunWith(SpringRunner.class)
public class PersonMapperTest {

	@InjectMocks
	PersonMapper personmapper;
	PersonView personview = new PersonView();
	Person cer = new Person();

	@Before
	public void data() {
		personview.setId("1");
		personview.setFirstname("rajan");
		personview.setLastname("f");
		personview.setAge("22");
		personview.setLocation("musiri");
		personview.setDegree("be");
		personview.setNumberofbook("5");
		personview.setSalary("30000");
		personview.setGender("MALE");
		personview.setStatus("ACTIVE");

		cer.setId(1);
		cer.setFirstname("rajan");
		cer.setLastname("f");
		cer.setAge(23);
		cer.setLocation("musiri");
		cer.setDegree("be");
		cer.setNumberofbook(5);
		cer.setSalary(new BigDecimal("30000"));
		cer.setGender(Gender.valueOf("MALE"));
		cer.setStatus(Status.valueOf("ACTIVE"));

	}

	@Test
	public void modelToEntityTestPer() {

		Person per = personmapper.modelToEntity(personview);
		String cer = personview.getLocation();

		assertEquals(per.getLocation(), cer);
	}

	@Test
	public void entityToModelPer() {

		PersonView mer = personmapper.entityToModel(cer);
		String der = cer.getDegree();
		assertEquals(mer.getDegree(), der);

	}
}
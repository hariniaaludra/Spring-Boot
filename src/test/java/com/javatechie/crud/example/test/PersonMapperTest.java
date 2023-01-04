package com.javatechie.crud.example.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;


//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
//import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Gender;
import com.javatechie.crud.example.enumeration.Status;
import com.javatechie.crud.example.mapper.PersonMapper;
import com.javatechie.crud.example.model.PersonView;

@ExtendWith(MockitoExtension.class)
class PersonMapperTest {

	@InjectMocks
	PersonMapper personmapper;
	PersonView personview = new PersonView();
	Person cer = new Person();

	@BeforeEach
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
	void modelToEntityTestPer() {

		Person per = personmapper.modelToEntity(personview);
		String cer = personview.getLocation();

		assertEquals(per.getLocation(), cer);
	}

	@Test
 void entityToModelPer() {

		PersonView mer = personmapper.entityToModel(cer);
		String der = cer.getDegree();
		assertEquals(mer.getDegree(), der);

	}
}
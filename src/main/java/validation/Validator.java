package validation;

import java.util.Optional;
//import java.util.regex.Matcher;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.javatechie.crud.example.entity.Book;
import com.javatechie.crud.example.entity.Person;
import com.javatechie.crud.example.enumeration.Gender;
import com.javatechie.crud.example.model.BookView;
import com.javatechie.crud.example.repository.BookRespository;
import com.javatechie.crud.example.repository.PersonRespository;

@Component
public class Validator {

	@Autowired
	BookRespository bookrepository;



	public void validate(BookView bookview) throws InvalidException {

		if (bookview.getFirstname().length() > 30) {

			throw new InvalidException("firstname can't be more than 30 char");

		}

		// if(bookview.getName().equals;

		if (Gender.data(bookview.getGender().toUpperCase()) == null) {
			throw new InvalidException("Invalid Value Gender");
		}

//		Pattern pattern = Pattern.compile("^[0-9]{2,5}");
//
//   		if (!pattern.matcher(bookview.getStock()).matches()) {
//
//			throw new InvalidException("Match not found");
//
//		}

	}

	public Person validato(Optional<Person> person) throws DataNotFoundException {
		if (person.isPresent()) {
			return person.get();
		} else {

			throw new DataNotFoundException("Data not found Exception");

		}
	
	}
}
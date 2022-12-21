package com.javatechie.crud.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.javatechie.crud.example.entity.Person;

	
@Component
	public interface PersonRespository extends JpaRepository<Person,Long> {

	}



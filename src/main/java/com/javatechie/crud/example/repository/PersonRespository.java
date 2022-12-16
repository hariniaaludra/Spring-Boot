package com.javatechie.crud.example.repository;

	//import javax.persistence.Access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Person;
	
@Service
	public interface PersonRespository extends JpaRepository<Person,Long> {

	}



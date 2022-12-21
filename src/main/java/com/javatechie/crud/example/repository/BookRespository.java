package com.javatechie.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.javatechie.crud.example.entity.Book;



@Repository
public interface BookRespository extends JpaRepository<Book, Long> {

}

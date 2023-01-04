package com.javatechie.crud.example.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.javatechie.crud.example.entity.Bank;

@Component
public interface BankRespository extends CrudRepository<Bank, Long> {

	Bank findTopByPasswordOrderByIdDesc(Integer ValueOf);
}
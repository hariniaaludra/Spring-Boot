package com.javatechie.crud.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Bank;
import com.javatechie.crud.example.mapper.BankMapper;
import com.javatechie.crud.example.model.BankView;
import com.javatechie.crud.example.repository.BankRespository;

@Service
public class BankService {
	@Autowired
	BankRespository repository;
	@Autowired
	BankMapper bankmapper;

	public Bank saveTheCredit(BankView bankview) {
		return repository.save(bankmapper.modelToEntity(bankview));
	}

	public Bank saveTheDebit(BankView bankview) {
		return repository.save(bankmapper.modelToEntity(bankview));
	}

	public Bank updateTheCredit(BankView bankview) {
		Bank bank = new Bank();
		Bank banking = repository.findTopByPasswordOrderByIdDesc(Integer.valueOf(bankview.getPassword()));

		Double ner = banking.getBalance();
		bank.setUsername(bankview.getUsername());
		bank.setPassword(Integer.valueOf(bankview.getPassword()));
		bank.setBalance(ner + Double.valueOf(bankview.getBalance()));
		return repository.save(bank);

	}

	public Bank updateTheDebit(BankView bankview) {
		Bank bank = new Bank();
		Bank banking = repository.findTopByPasswordOrderByIdDesc(Integer.valueOf(bankview.getPassword()));
		Double ner = banking.getBalance();
		bank.setUsername(bankview.getUsername());
		bank.setPassword(Integer.valueOf(bankview.getPassword()));
		bank.setBalance(ner - Double.valueOf(bankview.getBalance()));
		return repository.save(bank);
	}

	public Bank getId(int id) {

		return repository.findById(Long.valueOf(id)).orElse(null);
	}
}

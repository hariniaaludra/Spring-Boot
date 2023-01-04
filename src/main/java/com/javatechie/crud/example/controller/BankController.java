package com.javatechie.crud.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.crud.example.entity.Bank;
import com.javatechie.crud.example.model.BankView;
import com.javatechie.crud.example.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	private BankService service;
	@PostMapping("/amountcredit")
	public Bank amountCreditSave(@RequestBody BankView bankview) {
		return service.saveTheCredit(bankview);
	}
	@PostMapping("/amountdebit")
	public Bank amountDebitCreate(@RequestBody BankView bankview) {
		return service.saveTheDebit(bankview);
	}

	@PutMapping("/credit")
	public Bank amountCredit(@RequestBody BankView bankview) {
		return service.updateTheCredit(bankview);
	}

	@PutMapping("/debit")
	public Bank amountDebit(@RequestBody BankView bankview) {
		return service.updateTheDebit(bankview);
	}

	@GetMapping("/amountbalance")
	public Bank balanceCheck(@RequestBody int id) {
		return service.getId(id);
	}
}

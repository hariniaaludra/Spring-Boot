package com.javatechie.crud.example.mapper;

import org.springframework.stereotype.Component;

import com.javatechie.crud.example.entity.Bank;

import com.javatechie.crud.example.model.BankView;


@Component
public class BankMapper {

	public Bank modelToEntity(BankView bankview) {

		Bank bank = new Bank();
		
         if(bankview.getId() != null)
         {
		bank.setId(Long.valueOf(bankview.getId()));
         }
		bank.setUsername(bankview.getUsername());
		bank.setPassword(Integer.valueOf(bankview.getPassword()));
		bank.setBalance(Double.valueOf(bankview.getBalance()));
		return bank;

}
}
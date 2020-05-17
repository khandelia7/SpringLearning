package com.demo.service;

import org.springframework.stereotype.Component;

import com.demo.model.Bank;

@Component
public class BankService {

	public Bank fetchBank() {
		Bank bank =new Bank();
		bank.setId(1L);
		bank.setName("ICICI");
		return bank;
	}

}

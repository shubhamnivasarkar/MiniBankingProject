package com.app.service;

import com.app.pojos.BankAccount;

public interface IBankAccountService {
	BankAccount authenticateBankAccount(String email, String password);
	String deleteBankAccountHolderDetails(int accountId);
	BankAccount getAccountDetails(int accountId);
	String registerNewAccount(BankAccount accountHolder);
	
	String withdrawlBalance(int accountId, double balance);
	String depositBalance(int accountId, double balance);
}

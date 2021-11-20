package com.app.dao;

import com.app.pojos.BankAccount;

public interface IBankAccount {
	BankAccount authenticateBankAccount(String email, String password);
	String deleteBankAccountHolderDetails(BankAccount accountHolder);
	BankAccount getAccountDetails(int accountId);
	String registerNewAccount(BankAccount accountHolder);
	
	String withdrawlBalance(int accountId, double balance);
	String depositBalance(int accountId, double balance);
	
}

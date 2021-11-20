package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBankAccount;
import com.app.pojos.BankAccount;
@Service
@Transactional
public class BankAccountServiceImpl implements IBankAccountService {
@Autowired
private IBankAccount bankAccount;

	@Override
	public BankAccount authenticateBankAccount(String email, String password) {
		// TODO Auto-generated method stub
		return bankAccount.authenticateBankAccount(email, password);
	}

	@Override
	public String deleteBankAccountHolderDetails(int accountId) {
		// TODO Auto-generated method stub
		BankAccount acct = bankAccount.getAccountDetails(accountId);
		if(acct != null)
			return bankAccount.deleteBankAccountHolderDetails(acct);
		return "Invalid account, failed process, try again with correct account id";
	}

	@Override
	public BankAccount getAccountDetails(int accountId) {
		// TODO Auto-generated method stub
		return bankAccount.getAccountDetails(accountId);
	}

	@Override
	public String registerNewAccount(BankAccount accountHolder) {
		// TODO Auto-generated method stub
		return bankAccount.registerNewAccount(accountHolder);
	}

	@Override
	public String withdrawlBalance(int accountId, double balance) {
		// TODO Auto-generated method stub
		return bankAccount.withdrawlBalance(accountId, balance);
	}

	@Override
	public String depositBalance(int accountId, double balance) {
		// TODO Auto-generated method stub
		return bankAccount.depositBalance(accountId, balance);
	}
	
	
	
	

}

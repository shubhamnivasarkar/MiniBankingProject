package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.BankAccount;
@Repository
public class BankAccountImpl implements IBankAccount{
	BankAccountImpl bankAccountImpl;
	@Autowired
	private EntityManager manager;
	

	@Override
	public BankAccount authenticateBankAccount(String email, String password) {
		// TODO Auto-generated method stub
		String jpql = "select b from BankAccount b where b.email=:em and b.password=:pwd";
		return manager.createQuery(jpql, BankAccount.class).setParameter("em", email).setParameter("pwd", password).getSingleResult();
	}


	@Override
	public String deleteBankAccountHolderDetails(BankAccount accountHolder) {
		// TODO Auto-generated method stub
		System.out.println("account deleted "+accountHolder.getName());
		manager.remove(accountHolder);
		return "Account holder "+accountHolder.getName()+" has been deleted";
	}


	@Override
	public BankAccount getAccountDetails(int accountId) {
		// TODO Auto-generated method stub
		return manager.find(BankAccount.class, accountId);
	}


	@Override
	public String registerNewAccount(BankAccount accountHolder) {
		// TODO Auto-generated method stub
		manager.persist(accountHolder);
		return "New Account created successfully with ID"+accountHolder.getId();
	}


	@Override
	public String withdrawlBalance(int accountId, double balance) {
		// TODO Auto-generated method stub
		BankAccount acct= manager.find(BankAccount.class, accountId);
		double remainingBalance = acct.getBalance() - balance;
		acct.setBalance(remainingBalance);
		manager.merge(acct);
		return "Amount withdrawl successfully from account id "+accountId;
	}


	@Override
	public String depositBalance(int accountId, double balance) {
		// TODO Auto-generated method stub
		BankAccount acct = manager.find(BankAccount.class, accountId);
		double account = acct.getBalance();
		double afterDepositBalance = account + balance;
		acct.setBalance(afterDepositBalance);
		manager.merge(acct);
		return "Amount deposited successfully from account Id "+accountId;
	}
	
	
	
	
	
	
	
}

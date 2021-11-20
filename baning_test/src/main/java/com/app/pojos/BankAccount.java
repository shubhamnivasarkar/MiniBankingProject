package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "bankAccount")
public class BankAccount extends BaseEntity{
	@Column(name = "accountNumber")
	private String accountNumber;
	@Column(length = 50)
	private String name;
	@Column(length = 50)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 20, name = "acct_type")
	private AccountType type;
	@Column(length = 100, unique = true)
	private String email;
	@Column(name = "balance")
	private double balance;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
		System.out.println("in accounts holder constructor "+getClass().getName());
	}

	public BankAccount(String accountNumber, String name, String password, AccountType type, String email,
			double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.type = type;
		this.email = email;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", name=" + name + ", password=" + password + ", type="
				+ type + ", email=" + email + ", balance=" + balance + "]";
	}
	
	
	
	
	
}

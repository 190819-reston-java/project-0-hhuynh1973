package com.revature.model;


public class Account {
	private int accountNumber;
	private int pin;
    private double balance;
    private String accountType;
    private String client;
    
  
	


	public Account(int accountNumber, int pin, double balance, String accountType, String client) {
		super();
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
		this.accountType = accountType;
		this.client = client;
	}


	public Account(int accountNumber, int pin, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
	}
    
    
	public Account(int accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	
	
	public Account(double balance2) {
		super();
		this.balance = balance2;
	}


	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double amount) {
		System.out.println("Making a deposit...");
		this.setBalance(amount + this.getBalance());
	}

	public double withdraw(double amount) {
		System.out.println("Making a withdrawal...");
		this.setBalance(this.getBalance() - amount);
		
		return amount;
	}
	

	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}

}

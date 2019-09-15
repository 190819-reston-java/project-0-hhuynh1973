package com.revature.controller;
import java.util.Scanner;
import com.revature.model.Account;

public class Ledger {
	
	private Account accounts;
	
	
	public Ledger(Account accounts) {
		
		this.accounts = accounts;
	}

	
	public Account getAccounts() {
		return accounts;
	}




	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}




	public void balance(Account account) {
	
	        	System.out.println("We have " + account.getClient() + "'s account with us.\n" +
	        			"Your account balance is: " + account.getBalance());
	}
	
	
	
	public void deposit( Account account) {
		//TODO: implement deposit functionality
		System.out.println("Simulating deposit for " + account.getClient());
		System.out.println("How much would you like to deposit? ");
		Scanner inputAmount = new Scanner( System.in ); 
	    int input = inputAmount.nextInt();
	    if (account.getAccountType().equals("checking")) {
	                account.deposit(input);
	                System.out.println("Your new " + account.getAccountType() + 
	                		" account balance is: " + account.getBalance());
	    }

	            //if savings account add 5%
	    if (account.getAccountType().equals("saving")) {
	                input *= 1.05;
	                account.deposit(input);
	                System.out.println("Your new " + account.getAccountType() + " "
	                		+ "account balance is: " + account.getBalance());
	    }
	}
	


	public void withdraw(Account account) {
		//TODO: implement withdrawal
		System.out.println("Simulating withdrawal for " + account.getClient());
		System.out.println("How much would you like to withdraw? ");
		
		Scanner inputAmount = new Scanner( System.in ); 
	    int input = inputAmount.nextInt();

	            //if checking account
	    if (account.getAccountType().equals("checking")) {
	                account.withdraw(input);
	                System.out.println("Your new " + account.getAccountType() + " "
	                		+ "account balance is: " + account.getBalance());
	    }

	            //if savings account add $2 fee
	    if (account.getAccountType().equals("saving")) {
	                account.withdraw(input + 2.00);
	                System.out.println("Your new " + account.getAccountType() + " "
	                		+ "account balance is: " + account.getBalance());
	    }
	}

}

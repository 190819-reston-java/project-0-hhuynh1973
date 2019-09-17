package com.revature.service;
import java.util.Scanner;
import com.revature.model.Account;
import com.revature.repository.AccountDAO;
import com.revature.repository.AccountDAOimplJdbc;

public class Ledger {
	
	boolean inputAmountValid = false;
	private Account account;
	private AccountDAO selectAcctNo;


	

	public Ledger(AccountDAO selectAcctNo) {
		super();
		this.selectAcctNo = selectAcctNo;
	}


	public Ledger(Account account) {
		super();
		this.account = account;
	}


	public Ledger(AccountDAO selectAcctNo, Account account) {
		
		this.account = account;
		this.selectAcctNo = selectAcctNo;
	}

	
	public AccountDAO getSelectAcctNo() {
		return selectAcctNo;
	}


	public void setSelectAcctNo(AccountDAO selectAcctNo) {
		this.selectAcctNo = selectAcctNo;
	}


	public Account getAccounts() {
		return account;
	}




	public void setAccounts(Account accounts) {
		this.account = accounts;
	}




	public void balance() {
	
	        	System.out.println("We have " + account.getClient() + "'s account with us.\n" +
	        			"Your account balance is: " + account.getBalance());
	}
	
	
	
	public void deposit() {
		//TODO: implement deposit functionality
		System.out.println("Simulating deposit for " + account.getClient());
		System.out.println("How much would you like to deposit? ");
		Scanner inputAmount = new Scanner( System.in ); 
	    int input = inputAmount.nextInt();
	    
	    
	    
	    while(!inputAmountValid) {
	    	if(input <= 0) {
	    		System.out.println("Deposit amount can't be negative or zero. Please try again.");
	    		
	    		input = inputAmount.nextInt();
	    	}
	    	else {
	    		inputAmountValid = true;
	    
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
	    }
	    Account acct= new Account(account.getAccountNumber(), account.getBalance());
    	selectAcctNo.updateAccount(acct); 
	    
	}
	


	public void withdraw() {
		//TODO: implement withdrawal
		System.out.println("Simulating withdrawal for " + account.getClient());
		System.out.println("How much would you like to withdraw? ");
		
		Scanner inputAmount = new Scanner( System.in ); 
	    int input = inputAmount.nextInt();

	    while(!inputAmountValid) {
	    	if(input <= 0) {
	    		System.out.println("Deposit amount can't be negative or zero. Please try again.");
	    		input = inputAmount.nextInt();
	    	}
	    	else {
	    		inputAmountValid = true;
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
	    Account acct= new Account(account.getAccountNumber(), account.getBalance());
    	selectAcctNo.updateAccount(acct);
    	
	}

}

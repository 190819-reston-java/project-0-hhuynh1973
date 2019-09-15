package com.revature.controller;

import java.util.Scanner;

import com.revature.model.Account;
import com.revature.repository.AccountDAO;
import com.revature.repository.AccountDAOimplJdbc;
import com.revature.service.Ledger;

public class ATM {
	
	   private boolean userAuthenticated; // whether user is authenticated	
	
	   // constants corresponding to main menu options
	   private static final int BALANCE_INQUIRY = 1;
	   private static final int WITHDRAWAL = 2;
	   private static final int DEPOSIT = 3;
	   private static final int EXIT = 4;
	   
	   
	   

	// start ATM 
	   public void run()
	   {
	      // welcome and authenticate user; perform transactions
	      while ( true )
	      {
	         // loop while user is not yet authenticated
	         while ( !userAuthenticated ) 
	         {
	            System.out.println("\nWelcome!" );       
	            authenticateUser(); // authenticate user
	         } // end while
	         
	         
	         userAuthenticated = false; // reset before next ATM session
	         System.out.println("\nThank you! Goodbye!" );
	      } // end while   
	   } // end method run

	   private boolean authenticateUser() {
		
		   
		   	  System.out.println("\nPlease enter your account number: " );
		      Scanner inputAcct = new Scanner( System.in ); // input account number
		      int inputA = inputAcct.nextInt();
		      System.out.println("\nEnter your PIN: " ); // prompt for PIN
		      Scanner inputPin = new Scanner( System.in ); // input account number
		      int inputP = inputAcct.nextInt();// input PIN
		      
		    	  
		    	//return the account having both account number and pin
		    AccountDAO selectAcctNo = new AccountDAOimplJdbc();
			Account account = selectAcctNo.getAccount(inputA);
				  
			if(account == null) {//resultSet returns null
					  System.out.println("Invalid account number. Please try again...");
			    	  userAuthenticated = false;
		    		  
		    }
		    else {
		    	if(account.getAccountNumber() == inputA) {
		    		
		    		//then check PIN
		    		if ( account.getPin() == inputP ) {
		    			  System.out.println("Welcome " + account.getClient());
		    			  userAuthenticated = true;
		    			  performTransactions(account); // user is now authenticated 
		    			  
		    		}
		    		else {
		    			System.out.println("Invalid PIN");
		    		}
		    	}
		    	else {
		    			  System.out.println("Invalid account number");
		    			  userAuthenticated = false;
		    	}
		    	  
		    }
		      
		    
			  
			return userAuthenticated;
			
		      
	   }

 
				

	   // display the main menu and perform transactions
	   private Ledger performTransactions(Account acct) 
	   {
	      // local variable to store transaction currently being processed
	      //Ledger currentTransaction = new Ledger(currentAccountNumber);
	      Ledger myLedger = null;
	      boolean userExited = false; // user has not chosen to exit

	      // loop while user has not chosen option to exit system
	      while ( !userExited )
	      {     
	         // show main menu and get user selection
	         int mainMenuSelection = displayMainMenu();

	         // decide how to proceed based on user's menu selection
	         switch ( mainMenuSelection )
	         {
	            // user chose to perform one of three transaction types
	            case BALANCE_INQUIRY: 
	            	myLedger = new Ledger(acct);
	            	myLedger.balance(acct);
	            	break;
	            	
	            case WITHDRAWAL: 
	            	myLedger = new Ledger(acct);
	            	myLedger.withdraw(acct);
	            	break;
	            	
	            case DEPOSIT:
	            	myLedger = new Ledger(acct);
	            	myLedger.deposit(acct);
	               break; 
	            case EXIT: // user chose to terminate session
	               System.out.println("\nExiting the system..." );
	               userExited = true; // this ATM session should end
	               break;
	            default: // user did not enter an integer from 1-4
	               System.out.println( 
	                  "\nYou did not enter a valid selection. Try again." );
	               break;
	         } // end switch
	      } // end while
		return myLedger;
	   } // end method performTransactions
	   
	   // display the main menu and return an input selection
	   private int displayMainMenu()
	   {
	      System.out.println( "\nMain menu:" );
	      System.out.println( "1 - View my balance" );
	      System.out.println( "2 - Withdraw cash" );
	      System.out.println( "3 - Deposit funds" );
	      System.out.println( "4 - Exit\n" );
	      System.out.println( "Enter a choice: " );
	      Scanner keyPad = new Scanner( System.in ); // input account number
	      int inputK = keyPad.nextInt();// input PIN // return user's selection
	      return inputK;
	   } // end method displayMainMenu
	         
}

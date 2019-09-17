package com.revature;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.revature.model.Account;
import com.revature.repository.AccountDAO;
import com.revature.repository.AccountDAOimplJdbc;
import com.revature.service.Ledger;



public class LedgerTest {
	
	private static Ledger ledger = null;
	private Account acct = null;
	
	@Before
	public void setUp() {
		ledger = new Ledger(new AccountDaoMock());
	}
	
	@After
	public void tearDown() {
		ledger = null;
	}
	
	
	@Test
	public AccountDAOimplJdbc getAccountWithNonExistantAccountNumber() {
		
		int acctNo = 12367687;
		AccountDAO acctDaoimpl = null;
		assertNull("The account number you enter return null", (acctDaoimpl.getAccount(acctNo)));
		
		acct = acctDaoimpl.getAccount(acctNo);
		ledger = new Ledger(acct);
		ledger.withdraw();
		ledger.deposit();
		
		acct= new Account(acctNo, acct.getBalance());
		acctDaoimpl.updateAccount(acct); 
		
		assertTrue(acct.getBalance() == 400.00);
		
		return null;
		
	}


}

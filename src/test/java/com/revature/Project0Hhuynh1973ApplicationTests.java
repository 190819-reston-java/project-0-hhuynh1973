package com.revature;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;

import com.revature.model.Account;
import com.revature.repository.AccountDAO;
import com.revature.repository.AccountDAOimplJdbc;
import com.revature.service.Ledger;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class Project0Hhuynh1973ApplicationTests {
	private static Ledger ledger = null;
	private Account acct = null;
	int acctNo = 1234;
	

	@Before
	public void setUp() {
		ledger = new Ledger(new AccountDaoMock());
	}
	
	@After
	public void tearDown() {
		ledger = null;
	}
	

	@Test
	public void getAccountWithNonExistantAccountNumber() {
		
		
		AccountDAO acctDaoimpl = new AccountDAOimplJdbc();
		acct = acctDaoimpl.getAccount(acctNo);
		
		assertNotNull("The account number you enter return null", acct);
		
		ledger = new Ledger(acctDaoimpl, acct);
		ledger.withdraw();
		
		
		Account acctUpdate= new Account(acct.getBalance());
		acctDaoimpl.updateAccount(acctUpdate); 
		
		assertTrue(acctUpdate.getBalance() == 400.00);
		
	}
	
}

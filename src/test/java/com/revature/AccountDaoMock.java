package com.revature;

import com.revature.model.Account;
import com.revature.repository.AccountDAO;

public class AccountDaoMock implements AccountDAO{
	
	@Override
	public Account getAccount(int id) {
		
			return new Account(1, 0, 0, 0, "checking", "Mary");
	}

	

	@Override
	public boolean updateAccount(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

}

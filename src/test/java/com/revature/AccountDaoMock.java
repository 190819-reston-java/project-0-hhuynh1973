package com.revature;

import com.revature.model.Account;
import com.revature.repository.AccountDAO;

public class AccountDaoMock implements AccountDAO {

	@Override
	public Account getAccount(int account_number) {
		if(account_number == 1234) {
			return new Account(0, account_number, 1234, 0, "checking", "Mary");
		}
		return null;
	}

	@Override
	public boolean updateAccount(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

}

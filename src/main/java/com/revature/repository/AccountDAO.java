package com.revature.repository;

import com.revature.model.Account;

public interface AccountDAO {

	Account getAccount(int account_number);
	boolean updateAccount(Account a);
	
	
}

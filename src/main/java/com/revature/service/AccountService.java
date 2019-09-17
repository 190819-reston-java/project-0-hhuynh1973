package com.revature.service;

import com.revature.model.Account;
import com.revature.repository.AccountDAO;

public class AccountService {
	AccountDAO accountDao;
	Account acct;
	public AccountService(AccountDAO accountDao, Account acct) {
		super();
		this.accountDao = accountDao;
		this.acct = acct;
	}
	public AccountDAO getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}
	public Account getAcct() {
		return acct;
	}
	public void setAcct(Account acct) {
		this.acct = acct;
	}
	
	public void updateSelectedAccount() {
		accountDao.updateAccount(acct);
	}

}

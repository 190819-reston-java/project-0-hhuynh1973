package com.revature.exception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Account;
import com.revature.service.Ledger;

import util.ConnectionUtil;
import util.StreamCloser;

public class MyException {
	
	Account acctResult = tryCatchAccount();
	
	Ledger myLedger = new Ledger(acctResult);
	
	public void tryCatchLedger() {
		
		try {
			myLedger.deposit();
			myLedger.withdraw();
		}
		catch(Exception e) {
			
			System.out.println(e);
			
		}
		
	}
	
	
	
	public Account tryCatchAccount() {
		ResultSet resultSet = null;
		
		PreparedStatement statement =  null;
		
		Account acct = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
	
			statement = conn.prepareStatement(
					"SELECT * FROM account WHERE account_number = ? AND pin = ?");
			//System.out.println(account_number+ pin);
			statement.setInt(1, 1234);
			statement.setInt(2, 123);
			
			
			//try to execute SQL query
			if(statement.execute()) {
				//get the ResultSet
				resultSet =  statement.getResultSet();
				//check for a single row and use it
				if(resultSet.next()) {
					acct = createAccountFromRS(resultSet);
					
				}
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
		}
		return acct;
		
	}
	
	
	private Account createAccountFromRS(ResultSet resultSet) throws SQLException {
		return new Account(
				resultSet.getInt("id"),
				resultSet.getInt("account_number"),
				resultSet.getInt("pin"),
				resultSet.getDouble("balance"),
				resultSet.getString("account_type"),
				resultSet.getString("client"));
	}
	
}

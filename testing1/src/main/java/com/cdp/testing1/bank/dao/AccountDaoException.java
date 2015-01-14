package com.cdp.testing1.bank.dao;


public class AccountDaoException extends RuntimeException {

	public AccountDaoException(String msg) {
		super(msg);
	}

	public AccountDaoException(Exception e, String msg) {
		super(msg, e);
	}
	
}

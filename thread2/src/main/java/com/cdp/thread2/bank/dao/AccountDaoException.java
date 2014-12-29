package com.cdp.thread2.bank.dao;

import java.io.FileNotFoundException;

public class AccountDaoException extends RuntimeException {

	public AccountDaoException(String msg) {
		super(msg);
	}

	public AccountDaoException(Exception e, String msg) {
		super(msg, e);
	}
	
}

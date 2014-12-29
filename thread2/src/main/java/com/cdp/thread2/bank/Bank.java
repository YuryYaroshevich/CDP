package com.cdp.thread2.bank;

import java.util.Collection;
import java.util.List;

import com.cdp.thread2.bank.model.Account;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class Bank {
	private AccountService accountService = new AccountService();
	
	public List<Account> getAllAccounts() {
		return accountService.getAll();
	}
	
	public Collection<Account> filterAccounts(Predicate<Account> criteria) {
		return Collections2.filter(getAllAccounts(), criteria);
	}
}

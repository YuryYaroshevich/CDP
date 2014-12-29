package com.cdp.thread2.bank;

import java.util.List;

import com.cdp.thread2.bank.dao.AccountDao;
import com.cdp.thread2.bank.exchange.Exchanger;
import com.cdp.thread2.bank.model.Account;
import com.cdp.thread2.bank.model.Currency;

public class AccountService {
	private AccountDao accountDao = new AccountDao();
	private Exchanger exchanger = new Exchanger();
	
	public Account get(long id) {
		return accountDao.get(id);
	}
	
	public List<Account> getAll() {
		return accountDao.getAll();
	}
	
	public void save(Account account) {
		accountDao.save(account);
	}
	
	public void remove(long id) {
		accountDao.remove(id);
	}
	
	public Account exchange(Account account, Currency currency) {
		exchanger.exchange(account, currency);
		accountDao.save(account);
		return account;
	}
}

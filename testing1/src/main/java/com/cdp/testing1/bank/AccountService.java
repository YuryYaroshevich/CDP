package com.cdp.testing1.bank;

import java.math.BigDecimal;
import java.util.List;

import com.cdp.testing1.bank.dao.AccountDao;
import com.cdp.testing1.bank.exchange.Exchanger;
import com.cdp.testing1.bank.model.Account;
import com.cdp.testing1.bank.model.Currency;

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
		BigDecimal moneyInCurrency = exchanger.exchange(account, currency);
		account.getAccountViews().put(currency, moneyInCurrency);
		accountDao.save(account);
		return account;
	}
}

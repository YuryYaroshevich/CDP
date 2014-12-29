package com.cdp.thread2.bank.search;

import java.math.BigDecimal;
import java.util.Map;

import com.cdp.thread2.bank.model.Account;
import com.cdp.thread2.bank.model.Currency;
import com.google.common.base.Predicate;

public class ByCurrencyCriteria implements Predicate<Account> {
	private Currency currency;

	public ByCurrencyCriteria(Currency currency) {
		this.currency = currency;
	}
	
	@Override
	public boolean apply(Account account) {
		Map<Currency, BigDecimal> accountViews = account.getAccountViews();
		return accountViews.keySet().contains(currency);
	}
}

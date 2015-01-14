package com.cdp.testing1.bank.sorting;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;

import com.cdp.testing1.bank.exchange.Exchanger;
import com.cdp.testing1.bank.model.Account;
import com.cdp.testing1.bank.model.Currency;

public class ByMoneyComaparator implements Comparator<Account> {
	private Exchanger exchanger = new Exchanger();
	private Currency commonCurrency = Currency.values()[0];

	@Override
	public int compare(Account a1, Account a2) {
		BigDecimal money1 = recount(a1);
		BigDecimal money2 = recount(a2).negate();
		return money1.add(money2).signum();
	}
	
	private BigDecimal recount(Account account) {
		Map<Currency, BigDecimal> accountViews1 = account.getAccountViews();
		if (accountViews1.containsKey(commonCurrency)) {
			return accountViews1.get(commonCurrency);
		}		
		return exchanger.exchange(account, commonCurrency);
	}
}

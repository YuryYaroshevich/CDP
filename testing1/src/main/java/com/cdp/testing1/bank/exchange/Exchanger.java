package com.cdp.testing1.bank.exchange;

import java.math.BigDecimal;
import java.util.Map;

import com.cdp.testing1.bank.model.Account;
import com.cdp.testing1.bank.model.Currency;

public class Exchanger {
	private Recounter recounter = new Recounter();

	public BigDecimal exchange(Account account, Currency currency) {
		Map<Currency, BigDecimal> accountViews = account.getAccountViews();
		Currency oldCurrency = accountViews.keySet().iterator().next();
		BigDecimal moneyOldCurrency = accountViews.get(oldCurrency);
		return recounter.recount(oldCurrency, currency, moneyOldCurrency);
	}
}

package com.cdp.thread2.bank.exchange;

import java.math.BigDecimal;
import java.util.Map;

import com.cdp.thread2.bank.model.Account;
import com.cdp.thread2.bank.model.Currency;

public class Exchanger {
	private Recounter recounter = new Recounter();

	public void exchange(Account account, Currency currency) {
		if (account.getAccountViews().containsKey(currency)) {
			return;
		}
		
		Map<Currency, BigDecimal> accountViews = account.getAccountViews();
		Currency oldCurrency = accountViews.keySet().iterator().next();
		BigDecimal moneyOldCurrency = accountViews.get(oldCurrency);
		
		BigDecimal moneyNewCurrency = recounter.recount(oldCurrency, currency, moneyOldCurrency);
		
		accountViews.put(currency, moneyNewCurrency);
	}
}

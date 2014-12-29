package com.cdp.thread2.bank.exchange;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.cdp.thread2.bank.model.Currency;

class Recounter {
	private Map<BigDecimal, Currency[]> exchangeRatios;
	
	public Recounter() {
		exchangeRatios = new HashMap<>();
		
		exchangeRatios.put(new BigDecimal(55.595f),
				new Currency[] {Currency.DOLLAR, Currency.RUSSIAN_RUBLE});

		exchangeRatios.put(new BigDecimal(1.22f),
				new Currency[] {Currency.DOLLAR, Currency.EURO});

		exchangeRatios.put(new BigDecimal(68),
				new Currency[] {Currency.EURO, Currency.RUSSIAN_RUBLE});
	}

	public BigDecimal recount(Currency from, Currency to, BigDecimal money) {
		for (Entry<BigDecimal, Currency[]> entry : exchangeRatios.entrySet()) {
			Currency c0 = entry.getValue()[0];
			Currency c1 = entry.getValue()[1];
			BigDecimal ratio = entry.getKey();
			if (from.equals(c0) && to.equals(c1)) {
				return money.multiply(ratio, MathContext.DECIMAL32);
			} else if (from.equals(c1) && to.equals(c0)) {
				return money.divide(ratio, MathContext.DECIMAL32);
			}
		}
		throw new ExchangeException("Incorrect currencies.");
	}
}

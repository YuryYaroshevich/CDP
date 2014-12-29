package com.cdp.thread2.bank.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountView implements Serializable {
	private static final long serialVersionUID = 4533990561843680738L;
	
	private BigDecimal money;
	private Currency currency;
	
	public AccountView(BigDecimal money, Currency currency) {
		this.money = money;
		this.currency = currency;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountView other = (AccountView) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountView [money=" + money + ", currency=" + currency + "]";
	}
}

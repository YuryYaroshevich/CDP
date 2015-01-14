package com.cdp.testing1.bank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class Account implements Serializable {
	private static final long serialVersionUID = -3182123128177767773L;

	private long id;
	private Person person;
	private Map<Currency, BigDecimal> accountViews;

	public Account(Person person, Map<Currency, BigDecimal> accountViews) {
		this.person = person;
		this.accountViews = accountViews;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public Map<Currency, BigDecimal> getAccountViews() {
		return accountViews;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", person=" + person + ", accountViews="
				+ accountViews + "]";
	}
}

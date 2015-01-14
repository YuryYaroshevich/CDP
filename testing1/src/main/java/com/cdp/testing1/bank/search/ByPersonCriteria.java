package com.cdp.testing1.bank.search;

import com.cdp.testing1.bank.model.Account;
import com.cdp.testing1.bank.model.Person;
import com.google.common.base.Predicate;

public class ByPersonCriteria implements Predicate<Account> {
	private Person person;
	
	public ByPersonCriteria(Person person) {
		this.person = person;
	}

	@Override
	public boolean apply(Account account) {
		return person.equals(account.getPerson());
	}		
}
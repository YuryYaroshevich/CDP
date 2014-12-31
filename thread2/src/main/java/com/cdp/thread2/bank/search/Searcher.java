package com.cdp.thread2.bank.search;

import java.util.Collection;

import com.cdp.thread2.bank.model.Account;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class Searcher {
	public Collection<Account> filterAccounts(Collection<Account> accounts,
			Predicate<Account>... criterias) {
		for (Predicate<Account> criteria : criterias) {
			accounts = Collections2.filter(accounts, criteria);
		}
		return accounts;
	}
}

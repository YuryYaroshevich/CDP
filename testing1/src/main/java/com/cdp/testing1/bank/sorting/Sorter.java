package com.cdp.testing1.bank.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cdp.testing1.bank.model.Account;

public class Sorter {
	public List<Account> getOrderedAccounts(List<Account> accounts,
			Comparator<Account> orderConfig) {
		Collections.sort(accounts, orderConfig);
		return accounts;
	}
}

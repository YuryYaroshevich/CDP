package com.cdp.testing1.bank.sorting;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cdp.testing1.bank.model.Account;
import com.cdp.testing1.bank.model.Currency;
import com.cdp.testing1.bank.model.Person;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ByMoneyComparatorTest {
	private ByMoneyComaparator comparator = new ByMoneyComaparator(); 
	
	@Test
	public void compare_Ok() {
		Person p1 = new Person("batman");
		Map<Currency, BigDecimal> accountView = new HashMap<>();
		accountView.put(Currency.RUSSIAN_RUBLE, new BigDecimal(234));
		Account accWithMoreMoney = new Account(p1, accountView);
		
		Map<Currency, BigDecimal> accountView2 = new HashMap<>();
		accountView2.put(Currency.RUSSIAN_RUBLE, new BigDecimal(147));
		Account accWithLessMoney = new Account(p1, accountView2);
		
		assertThat(comparator.compare(accWithMoreMoney, accWithLessMoney), greaterThan(0));
	}
}

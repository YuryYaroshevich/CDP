package com.cdp.thread2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

import com.cdp.thread2.bank.AccountService;
import com.cdp.thread2.bank.dao.AccountDao;
import com.cdp.thread2.bank.exchange.Exchanger;
import com.cdp.thread2.bank.model.Account;
import com.cdp.thread2.bank.model.Currency;
import com.cdp.thread2.bank.model.Person;


public class Runner {
	static {
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(
				"%m%n")));
	}

	public static void main(String[] args) throws Exception {
		Person p = new Person("batman");
		Map<Currency, BigDecimal> accountViews = new HashMap<>();
		accountViews.put(Currency.RUSSIAN_RUBLE, new BigDecimal(234));
		final Account ac = new Account(p, accountViews);
		
		final AccountDao dao = new AccountDao();
		final Exchanger exchangeService = new Exchanger();
		dao.save(ac);
		System.out.println(ac);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				exchangeService.exchange(ac, Currency.DOLLAR);
				dao.save(ac);
			}			
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				exchangeService.exchange(ac, Currency.EURO);
				dao.save(ac);
			}			
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(dao.get(ac.getId()));
		AccountService accountService = new AccountService();
		accountService.remove(1);
	}
}

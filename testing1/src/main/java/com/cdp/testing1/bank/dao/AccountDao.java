package com.cdp.testing1.bank.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.cdp.testing1.bank.model.Account;

public class AccountDao {
	private static final String ACCOUNT_FILES_FOLDER = "accounts/";

	private volatile long idSequence = 0;
	private ConcurrentMap<Long, Object> accountSynchronizers = new ConcurrentHashMap<>();

	private AccountSerializer accountSerializer = new AccountSerializer();

	public AccountDao() {
		File accountsDir = new File(ACCOUNT_FILES_FOLDER);
		File[] accountFiles = accountsDir.listFiles();
		for (File accountFile : accountFiles) {
			Long accountId = Long.valueOf(accountFile.getName());
			accountSynchronizers.put(accountId, new Object());
		}
	}
	
	public Account get(long id) {
		Object lock = accountSynchronizers.get(id);
		checkLock(lock, id);
		synchronized (lock) {
			String fileName = ACCOUNT_FILES_FOLDER + String.valueOf(id);
			return accountSerializer.deserialize(fileName);
		}
	}
	
	public List<Account> getAll() {
		List<Account> accounts = new ArrayList<>();
		for (Iterator<Long> iter = accountSynchronizers.keySet().iterator(); iter.hasNext();) {
			Long accountId = iter.next();
			synchronized (accountSynchronizers.get(accountId)) {
				Account account = accountSerializer.deserialize(accountId.toString());
				accounts.add(account);
			}
		}
		return accounts;
	}

	public void save(Account account) {
		Object lock = null;
		if (account.getId() == 0) {
			idSequence++;
			lock = new Object();
			accountSynchronizers.putIfAbsent(idSequence, lock);
			lock = accountSynchronizers.get(idSequence);
			synchronized (lock) {
				account.setId(idSequence);
				String fileName = ACCOUNT_FILES_FOLDER
						+ String.valueOf(account.getId());
				accountSerializer.serialize(account, fileName);
			}
		} else {
			lock = accountSynchronizers.get(account.getId());
			synchronized (lock) {
				String fileName = ACCOUNT_FILES_FOLDER
						+ String.valueOf(account.getId());
				Account accountOldVersion = accountSerializer.deserialize(fileName);
				account.getAccountViews().putAll(accountOldVersion.getAccountViews());
				accountSerializer.serialize(account, fileName);
			}
		}		
	}

	public void remove(long id) {
		Object lock = accountSynchronizers.get(id);
		checkLock(lock, id);
		synchronized (lock) {
			File accountFile = new File(ACCOUNT_FILES_FOLDER
					+ String.valueOf(id));
			accountFile.delete();
			accountSynchronizers.remove(id);
		}
	}

	private static void checkLock(Object lock, long id) {
		if (lock == null) {
			throw new AccountDaoException("Account with id = " + id
					+ " doesn't exist.");
		}
	}

}

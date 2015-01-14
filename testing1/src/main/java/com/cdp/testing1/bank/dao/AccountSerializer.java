package com.cdp.testing1.bank.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.cdp.testing1.bank.model.Account;

public class AccountSerializer {
	public void serialize(Account account, String fileName) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(
				new FileOutputStream(new File(fileName)))) {			
			outputStream.writeObject(account);
		} catch (FileNotFoundException e) {
			throw new AccountDaoException(e, "Acount file not found.");
		} catch (IOException e) {
			throw new AccountDaoException(e, "Error occurred while writing to a file.");
		}
	}
	
	public Account deserialize(String fileName) {
		try (ObjectInputStream inputStream = new ObjectInputStream(
				new FileInputStream(new File(fileName)))) {			
			Account account = (Account) inputStream.readObject();
			return account;
		} catch (FileNotFoundException e) {
			throw new AccountDaoException(e, "Acount file not found.");
		} catch (IOException e) {
			throw new AccountDaoException(e, "Error occurred while reading account file.");
		} catch (ClassNotFoundException e) {
			throw new AccountDaoException(e, "Internal error.");
		} 
	}
}

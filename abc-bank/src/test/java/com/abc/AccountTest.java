package com.abc;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class AccountTest {
    @Test(expected = IllegalArgumentException.class)
    public void deposit_NegativeAmount_throwException() {
        Account account = new Account(Account.SAVINGS);
        account.deposit(-2.1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void withdraw_NegativeAmount_throwException() {
        Account account = new Account(Account.SAVINGS);
        account.withdraw(-2.1);
    }
    
    @Test
    public void interestEarned_AmountLessThan1000AndAccTypeMAXI_SAVINGS() {
        Account account = new Account(Account.MAXI_SAVINGS);
        account.transactions = Lists.newArrayList(new Transaction(10), new Transaction(200));
        
        Assert.assertTrue(account.interestEarned() == 4.2);
    }
    
    @Test
    public void interestEarned_AmountGreaterThan1000LessThan2000AndAccTypeMAXI_SAVINGS() {
        Account account = new Account(Account.MAXI_SAVINGS);
        account.transactions = Lists.newArrayList(new Transaction(1000), new Transaction(200));
        
        Assert.assertTrue(account.interestEarned() == 30);
    }
    
    @Test
    public void interestEarned_AmountLessThan1000() {
        Account account = new Account(Account.SAVINGS);
        account.transactions = Lists.newArrayList(new Transaction(10), new Transaction(200));
        
        Assert.assertTrue(account.interestEarned() == 0.21);
    }
}

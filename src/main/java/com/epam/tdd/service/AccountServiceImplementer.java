package com.epam.tdd.service;

import com.epam.tdd.exception.InvalidAccountException;
import com.epam.tdd.domain.Account;

public class AccountServiceImplementer implements AccountService {
    @Override
    public void create(Account account) throws InvalidAccountException {
        if (hasNotValidLength(account) || ! account.getAccountName().matches("^[a-z_]*$") ||
                account.getUserName()==null || account.getPassword()==null ) {
            throw new InvalidAccountException();
        }
    }
    private boolean hasNotValidLength(Account account) {
        return account.getAccountName() == null ||
                account.getAccountName().length() < 5 || account.getAccountName().length() > 20;
    }
}
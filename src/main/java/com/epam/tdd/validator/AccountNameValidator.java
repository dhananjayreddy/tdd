package com.epam.tdd.validator;

import com.epam.tdd.domain.Account;

public class AccountNameValidator implements FieldValidator {
    @Override
    public boolean isValid(Account account) {
        return !hasNotValidAccountName(account);
    }

    private boolean hasNotValidAccountName(Account account){
        return hasNotValidAccountLength(account) || ! account.getAccountName().matches("^[a-z_]*$");
    }

    private boolean hasNotValidAccountLength(Account account) {
        return account.getAccountName() == null ||
                account.getAccountName().length() < 5 || account.getAccountName().length() > 20;
    }
}


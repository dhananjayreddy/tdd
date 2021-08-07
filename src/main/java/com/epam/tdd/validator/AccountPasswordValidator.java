package com.epam.tdd.validator;

import com.epam.tdd.domain.Account;

public class AccountPasswordValidator implements FieldValidator{
    @Override
    public boolean isValid(Account account) {
        return !isInvalidPassword(account);
    }

    private boolean isInvalidPassword(Account account) {
        return isInValidPasswordLength(account) ||
                !account.getPassword().matches("^(?=.*[0-9])"
                        + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=.*[@#$%^&+=])"
                        + "(?=\\S+$).{8,}$");
    }

    private boolean isInValidPasswordLength(Account account) {
        return account.getPassword() == null ||
                account.getPassword().length() < 8;
    }

}


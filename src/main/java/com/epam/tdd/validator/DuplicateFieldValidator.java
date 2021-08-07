package com.epam.tdd.validator;

import com.epam.tdd.domain.Account;

public class DuplicateFieldValidator implements FieldValidator {
    @Override
    public boolean isValid(Account account) {
        return true;
    }
}

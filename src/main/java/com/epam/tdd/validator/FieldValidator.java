package com.epam.tdd.validator;

import com.epam.tdd.domain.Account;

public interface FieldValidator {
    boolean isValid(Account account);

}

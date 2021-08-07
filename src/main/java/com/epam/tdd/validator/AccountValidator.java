package com.epam.tdd.validator;

import com.epam.tdd.domain.Account;
import com.epam.tdd.exception.AccountAlreadyExistsException;

public interface AccountValidator {
    void validate(Account account) throws AccountAlreadyExistsException;
}

package com.epam.tdd.validator;

import com.epam.tdd.domain.Account;
import com.epam.tdd.exception.AccountAlreadyExistsException;

public class AccountValidatorImplementer implements AccountValidator {
    private FieldValidator fieldValidator;
    public AccountValidatorImplementer(FieldValidator fieldValidator){
        this.fieldValidator = fieldValidator;
    }

    @Override
    public void validate(Account account) throws AccountAlreadyExistsException {
        boolean isAccountNotExists = fieldValidator.isValid(account);
        if(!isAccountNotExists){
            throw new AccountAlreadyExistsException("Account already exists in the system");
        }
    }
}

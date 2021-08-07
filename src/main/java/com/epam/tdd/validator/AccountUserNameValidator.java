package com.epam.tdd.validator;

import com.epam.tdd.domain.Account;

public class AccountUserNameValidator implements FieldValidator{
    @Override
    public boolean isValid(Account account) {
        if(account.getUserName()==null || account.getUserName().length()<5){
            return false;
        }
        return true;
    }
}

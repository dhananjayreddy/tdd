package com.epam.tdd.service;

import com.epam.tdd.exception.InvalidAccountException;
import com.epam.tdd.domain.Account;

public interface AccountService {
    void create(Account account)throws InvalidAccountException;
}

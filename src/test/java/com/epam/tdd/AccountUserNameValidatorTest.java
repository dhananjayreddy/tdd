package com.epam.tdd;

import com.epam.tdd.domain.Account;
import com.epam.tdd.validator.AccountUserNameValidator;
import com.epam.tdd.validator.FieldValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountUserNameValidatorTest {
    private FieldValidator fieldValidator;

    @BeforeEach
    public void setUp(){
        fieldValidator = new AccountUserNameValidator();
    }

    @Test
    @DisplayName("Account User Name should not be null")
    public void accountUserNameShouldNotBeNull(){
        Account account = new Account("" , null , "");
        Assertions.assertFalse(fieldValidator.isValid(account));
    }

    @Test
    @DisplayName("Account User Name Should Have Min five chars")
    public void accountUserNameShouldHaveMinFiveCharacters(){
        Account account = new Account("" , "dj" , "");
        Assertions.assertFalse(fieldValidator.isValid(account));
    }
    @Test
    @DisplayName("Valid User Name Should not be null and Have Min five chars")
    public void validAccountUserNameShouldNotBeNullAndHaveMinFiveCharacters(){
        Account account = new Account("" , "dhananjay" , "");
        Assertions.assertTrue(fieldValidator.isValid(account));
    }
}


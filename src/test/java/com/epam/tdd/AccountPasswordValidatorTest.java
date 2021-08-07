package com.epam.tdd;

import com.epam.tdd.domain.Account;
import com.epam.tdd.validator.AccountPasswordValidator;
import com.epam.tdd.validator.FieldValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountPasswordValidatorTest {
    private FieldValidator fieldValidator;

    @BeforeEach
    public void setUp(){
        fieldValidator = new AccountPasswordValidator();
    }


    @Test
    @DisplayName("Account password should not be null")
    public void accountPasswordShouldNotNull(){
        FieldValidator fieldValidator = new AccountPasswordValidator();
        Account account = new Account("","",null);
        Assertions.assertFalse(fieldValidator.isValid(account));
    }

    @Test
    @DisplayName("Account password of minimum of 8 chars")
    public void accountPasswordShouldHaveMinEightCharacters(){
        Account account = new Account("","","dhanuu");
        Assertions.assertFalse(fieldValidator.isValid(account));
    }

    @Test
    @DisplayName("Account password should have special characters")
    public void accountPasswordShouldHaveMixedAlphaNumericWithSpecialCharacters(){
        Account account = new Account("","","dhananjay1999");
        Assertions.assertFalse(fieldValidator.isValid(account));
    }

    @Test
    @DisplayName("Account password should have alphanumeric with special characters")
    public void validAccountPassword(){
        Account account = new Account("","","dhananjay@1999");
        Assertions.assertTrue(fieldValidator.isValid(account));
    }
}

package com.epam.tdd;

import com.epam.tdd.domain.Account;
import com.epam.tdd.validator.AccountNameValidator;
import com.epam.tdd.validator.FieldValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountNameValidatorTest {
    private FieldValidator fieldValidator;

    @BeforeEach
    public void setUp(){
        fieldValidator = new AccountNameValidator();
    }

    @Test
    @DisplayName("Account name should be minimum of 5 chars")
    public void accountNameShouldHaveMinFiveCharacters(){
        Account account = new Account("djk","","");
        Assertions.assertFalse(fieldValidator.isValid(account));
    }

    @Test
    @DisplayName("Account name should not be null")
    public void accountNameShouldNotBeNull(){
        Account account = new Account(null,"","");
        Assertions.assertFalse(fieldValidator.isValid(account));
    }

    @Test
    @DisplayName("Account name should have maximum length of 20 chars")
    public void accountNameShouldHaveMaxTwentyCharacters(){
        Account account = new Account("Dhananjayareddykarridjrk","","");
        Assertions.assertFalse(fieldValidator.isValid(account));
    }

    @Test
    @DisplayName("Account name should have only alphabets")
    public void accountNameShouldHaveOnlyAlphabets(){
        Account account = new Account("dj1234","","");
        Assertions.assertFalse(fieldValidator.isValid(account));
    }


    @Test
    @DisplayName("Account name should only contains small alphabets")
    public void accountNameShouldHaveLowerCaseChars(){
        Account account = new Account("DhanANJay","","");
        Assertions.assertFalse(fieldValidator.isValid(account));
    }

    @Test
    @DisplayName("Account name can contain Underscore")
    public void accountNameCanHaveUnderScore(){
        Account account = new Account("Dhananjaya_Karri","","");
        Assertions.assertTrue(fieldValidator.isValid(account));
    }

    @Test
    @DisplayName("Valid Account name with chars between five and twenty")
    public void validAccountName(){
        Account account = new Account("DhananjayaKarri","","");
        Assertions.assertTrue(fieldValidator.isValid(account));
    }

}

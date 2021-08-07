package com.epam.tdd;

import com.epam.tdd.domain.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

// TODO : account name should have min length of 5 chars
// TODO : account name should have max length of 20 chars
// TODO : account name should have only alphabets
// TODO : account name should only contain small alphabets
// TODO : account name can contain Underscores
// TODO : Account should have user name and password
// TODO : account name cannot be null


public class AccountServiceTest {
    private static AccountService accountService;

    @BeforeAll
    public static void intializeAccountService(){
        accountService= new AccountServiceImplementer();
    }

    @Test
    public void accountNameShouldHaveMinimumOfFiveCharacters(){
        AccountService accountService=new AccountServiceImplementer();
        Account account=new Account("","","");
        Exception exception= assertThrows(
                InvalidAccountException.class,
                ()->{
                    accountService.create(account);
                });
    }

    @Test
    @DisplayName("Account Name should not be null. Throw Exception")
    public void throwInvalidAccountExceptionWhenAccountNameIsNull(){
        AccountService accountService=new AccountServiceImplementer();
        Account account=new Account("null","","");
        Exception exception= assertThrows(
                InvalidAccountException.class,
                ()->{
                    accountService.create(account);
                });
    }

    @Test
    @DisplayName("Account should not have more than 20 characters. Throw Exception")
    public void throwInvalidAccountExceptionWhenAccountNameShouldContainMoreThanTwentyCharacters(){
        AccountService accountService=new AccountServiceImplementer();
        Account account=new Account("dhananjayareddykarridjrk","","");
        Exception exception= assertThrows(
                InvalidAccountException.class,
                ()->{
                    accountService.create(account);
                });
    }

    @Test
    @DisplayName("Account name should only have alphabets")
    public void throwInvalidAccountExceptionWhenAccountNameShouldNotContainAlphabets(){
        AccountService accountService=new AccountServiceImplementer();
        Account account=new Account("dhananjay1999","","");
        Exception exception= assertThrows(
                InvalidAccountException.class,
                ()->{
                    accountService.create(account);
                });
    }

    @Test
    @DisplayName("account name should only have small alphabets")
    public void throwInvalidAccountExceptionWhenAccountNameShouldNotContainSmallAlphabets(){
        AccountService accountService=new AccountServiceImplementer();
        Account account=new Account("dhananJaY","","");
        Exception exception= assertThrows(
                InvalidAccountException.class,
                ()->{
                    accountService.create(account);
                });
    }

    @Test
    @DisplayName("account name can contain Underscores")
    public void accountNameCanHaveUnderscoreChar(){
        AccountService accountService=new AccountServiceImplementer();
        Account account=new Account("Dhananjaya_Karri","","");
        assertDoesNotThrow(
                ()->{
                    accountService.create(account);
                }
        );
    }

    @Test
    @DisplayName("account should have username and password")
    public void accountShouldHaveUsernameAndPassword(){
        Account account=new Account("Dhananjaya_Karri",null,null);
        Exception exception= assertThrows(
                InvalidAccountException.class,
                ()->{
                    accountService.create(account);
                });
    }


}


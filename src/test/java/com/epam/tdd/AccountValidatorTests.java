package com.epam.tdd;

import com.epam.tdd.domain.Account;
import com.epam.tdd.exception.AccountAlreadyExistsException;
import com.epam.tdd.validator.AccountValidator;
import com.epam.tdd.validator.AccountValidatorImplementer;
import com.epam.tdd.validator.FieldValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class AccountValidatorTests {
    @Mock
    private FieldValidator fieldValidator;
    @Test
    @DisplayName("Validate if account already exists. If exists throw an com.epam.tdd.domain.exception for client.")
    public void throwAccountAlreadyExistsExceptionWhenAccountExists() throws AccountAlreadyExistsException {
        Assertions.assertNotNull(fieldValidator);

        AccountValidator accountValidator =new AccountValidatorImplementer(fieldValidator);
        Account account=new Account("Dhananjaya_Karri","dhananjay","dhananjay@1999");
        when(fieldValidator.isValid(account))
                .thenReturn(false);
        Exception exception=assertThrows(
                AccountAlreadyExistsException.class,
                ()->{
                    accountValidator.validate(account);
                }
        );
    }


}

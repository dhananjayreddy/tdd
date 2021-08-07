package com.epam.tdd.validator;

public final class FieldValidatorFactory {
    private FieldValidatorFactory() {};
    public enum AccountValidatorType{
        DUPLICATE_ACCOUNT_VALIDATOR,
        ACCOUNT_NAME_VALIDATOR,
        ACCOUNT_USER_NAME_VALIDATOR,
        ACCOUNT_PASSWORD_VALIDATOR
    };
    public FieldValidator createValidator(AccountValidatorType ofType){
        FieldValidator fieldValidator;
        switch(ofType){
            case DUPLICATE_ACCOUNT_VALIDATOR:
                fieldValidator =new DuplicateFieldValidator();
                break;
            case ACCOUNT_USER_NAME_VALIDATOR:
                fieldValidator=new AccountUserNameValidator();
                break;
            case ACCOUNT_PASSWORD_VALIDATOR:
                fieldValidator=new AccountPasswordValidator();
                break;
            default:
                fieldValidator =new AccountNameValidator();
                break;
        }
        return fieldValidator;
    }

    private static FieldValidatorFactory instance;

    public static FieldValidatorFactory getInstance(){
        if(null==instance){
            instance= new FieldValidatorFactory();
        }
        return instance;
    }
}


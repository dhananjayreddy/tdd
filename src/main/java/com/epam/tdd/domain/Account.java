package com.epam.tdd.domain;

public class Account {
    private String accountName;
    private String userName;
    private String password;

    public Account(String accountName, String userName, String password) {
        this.accountName = accountName;
        this.userName = userName;
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getUserName() { return userName;}

    public String getPassword() {return password;}
}

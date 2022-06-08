package com.codecool.shop.model.user;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Bank(){
        accounts.add(Account.ACCOUNT_1);
        accounts.add(Account.ACCOUNT_2);
        accounts.add(Account.ACCOUNT_3);
    }

    protected Account getAccount(int recquiredAccountNr){
        for (Account account: this.accounts){
            if (account.getAccountNr() == recquiredAccountNr){
                return account;
            }
        }return null;
    }

}

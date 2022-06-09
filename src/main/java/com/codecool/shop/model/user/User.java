package com.codecool.shop.model.user;

import java.math.BigDecimal;

public enum User {

    BELA("Bela", 9876, Account.ACCOUNT_2),
    TIVADAR( "Tivadar", 5678, Account.ACCOUNT_1),
    GIZI("Gizus", 1234, Account.ACCOUNT_3)
    ;

    private String name;
    private int cardNr;
    private Account account;

    User(String name, int cardNr, Account account) {
        this.name = name;
        this.cardNr = cardNr;
        this.account = account;
    }


    public String getName() {
        return name;
    }

    public int getCardNr() {
        return cardNr;
    }

    public Account getAccount() {
        return account;
    }


    @Override
    public String toString(){
        return "\nUser: " + this.name + " card number: "+ this.cardNr+", starter balance: 3000";
    }

}

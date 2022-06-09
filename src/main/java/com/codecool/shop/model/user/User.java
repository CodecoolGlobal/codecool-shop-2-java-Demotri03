package com.codecool.shop.model.user;

import java.math.BigDecimal;

public enum User {
    BELA("Bela", 9876),
    TIVADAR( "Tivadar", 5678),
    GIZI("Gizus", 1234)
    ;

    private String name;
    private int cardNr;
    //private Account account;

    User(String name, int cardNr) {
        this.name = name;
        this.cardNr = cardNr;
       // this.account =
    }


    public String getName() {
        return name;
    }

    public int getCardNr() {
        return cardNr;
    }

    @Override
    public String toString(){
        return "\nUser: " + this.name + ", card number: " + this.cardNr;
    }

}

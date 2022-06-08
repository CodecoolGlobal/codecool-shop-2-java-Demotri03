package com.codecool.shop.model.user;

import java.math.BigDecimal;

public enum User {
    BELA("Bela", 1234),
    TIVADAR( "Tivadar", 5678),
    GIZI("Gizus", 9876)
    ;

    private String name;
    private int cardNr;
    //private Account account;

    User(String name, int cardNr) {
        this.name = name;
        this.cardNr = cardNr;
       // this.account =
    }

}

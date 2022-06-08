package com.codecool.shop.service;

import java.math.BigDecimal;

public enum User {
    BELA("Bela", BigDecimal.valueOf(1000) ),
    TIVADAR( "Tivadar", BigDecimal.valueOf(1300)),
    GIZI("Gizus", BigDecimal.valueOf(1600))
    ;

    private String name;
    private BigDecimal accountBalance;

    User(String name, BigDecimal accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
    }

    public boolean haveEnoughMoney(BigDecimal price){
        return price.intValue() <= this.accountBalance.intValue();
    }
}

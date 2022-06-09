package com.codecool.shop.model.user;

import java.math.BigDecimal;

public enum Account {


    ACCOUNT_1(1234, 1000 ),
    ACCOUNT_2( 5678, 2000),
    ACCOUNT_3( 9876, 3000)
    ;



   private int id;
   private int accountNr;
   private BigDecimal balance;

    Account(int accountNr, int balanceInt) {
        this.accountNr = accountNr;
        this.balance = new BigDecimal(balanceInt);
    }

    protected int getAccountNr() {
        return accountNr;
    }

    protected BigDecimal getBalance() {
        return balance;
    }

    protected boolean hasAccountCover(BigDecimal price){
        BigDecimal resultBalance = this.balance.subtract(price);
        int result = resultBalance.compareTo(BigDecimal.ZERO);
        return result >= 0;
    }

    private void setBalance(BigDecimal price){
        if (hasAccountCover(price)){
            this.balance = this.balance.subtract(price);
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void pay(Order order){
        try{
            setBalance(order.getPurchasePrice());
            order.getPayed();
        }catch (IllegalArgumentException e){
            System.out.println("There is not enough balance on account");

        }finally {
            System.out.println("Balance: " + this.balance);
        }
    }

}

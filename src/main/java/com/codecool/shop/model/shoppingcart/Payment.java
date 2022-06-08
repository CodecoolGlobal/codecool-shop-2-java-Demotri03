package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.service.User;

import java.math.BigDecimal;
import java.util.Random;

public class Payment {
    private BigDecimal amount;
    private User user;

    public Payment(BigDecimal amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    public boolean paymentCovered(){
        return this.user.haveEnoughMoney(amount);
    }

    public boolean connectedToBank(){
        var random = new Random();
        return random.nextBoolean();
    }
@Override
    public String toString(){
        if (paymentCovered() && connectedToBank()){
         return "Payment successful";
        }else{
            if (!paymentCovered()){
                return "Payment failed, purchase not covered by bank";
            }
            return "Connection failed, try again";
        }
    }


}

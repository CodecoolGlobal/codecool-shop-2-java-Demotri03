package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.model.user.User;

import java.math.BigDecimal;
import java.util.Random;

public class Payment {
    private Cart carttoOrder;
    private BigDecimal amount;
    private int id;
    private User user;

    public Payment(Cart cart, BigDecimal purchasePrice) {
        this.amount = purchasePrice;
        this.user = User.GIZI;
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

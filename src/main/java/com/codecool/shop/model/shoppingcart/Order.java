package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.model.user.User;

import java.math.BigDecimal;

import static java.lang.Integer.valueOf;

public class Order{
    private Cart carttoOrder;
    private BigDecimal purchasePrice;
    private int id;
    private User user;


    public Order(Cart cart, BigDecimal purchasePrice, User user) {
        this.carttoOrder = cart;
        this.purchasePrice = purchasePrice;
        this.user = user;
        this.id = cart.getId();
    }


    public void pay(){

    }

    @Override
    public String toString() {
        var strBuilder = new StringBuilder("Order details: { order id: ")
                .append(id)
                .append("\n");
        carttoOrder.getLineItems().forEach((item, amount) -> {
            strBuilder.append(item)
                    .append(": ")
                    .append(amount)
                    .append(" amount\n")
                    .append("total price: ")
                    .append(purchasePrice)
                    .append("}");
        });
        return (carttoOrder.getLineItems().size() > 0 ? strBuilder.toString() : "There is nothing in ordered items \n");
    }
}

package com.codecool.shop.model.user;

import com.codecool.shop.model.shoppingcart.Cart;
import com.codecool.shop.model.user.User;

import java.math.BigDecimal;

import static java.lang.Integer.valueOf;

public class Order {
    private Cart carttoOrder;
    private int id;
    private User user;
    private BigDecimal purchasePrice;
    private boolean payed;


    public Order(Cart cart) {
        this.carttoOrder = cart;
        this.id = cart.getId();
        this.user = cart.getUser();
        this.purchasePrice = cart.getPrice();
        this.payed = false;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public boolean isPayed(){
        return this.payed;
    }

    protected void getPayed(){
        this.payed = true;
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

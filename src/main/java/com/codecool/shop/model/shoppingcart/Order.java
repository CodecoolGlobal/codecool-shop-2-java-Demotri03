package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.model.BaseModel;
import com.codecool.shop.model.Product;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import static java.lang.Integer.valueOf;

public class Order{
    private Cart carttoOrder;
    private BigDecimal purchasePrice;
    private int id;


    public Order(Cart cart, BigDecimal purchasePrice) {
        this.carttoOrder = cart;
        this.purchasePrice = purchasePrice;
        this.id = cart.getId();

    }


    @Override
    public String toString() {
        var strBuilder = new StringBuilder("Order details: { order id: ")
                .append("\n");
        carttoOrder.getLineItems().forEach((item, amount) -> {
            strBuilder.append(item)
                    .append(": ")
                    .append(amount)
                    .append(" pieces\n")
                    .append("total price: ")
                    .append(purchasePrice)
                    .append("}");
        });
        return (carttoOrder.getLineItems().size() > 0 ? strBuilder.toString() : "There is nothing in ordered items \n");
    }
}

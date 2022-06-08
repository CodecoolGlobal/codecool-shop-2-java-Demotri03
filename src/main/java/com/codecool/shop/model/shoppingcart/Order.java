package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.model.Product;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import static java.lang.Integer.valueOf;

public class Order {
    private Map<Product, Integer> orderedItems;
    private BigDecimal purchasePrice;
    private UUID id;


    public Order(Map<Product, Integer> orderedItems, BigDecimal purchasePrice) {
        this.orderedItems = orderedItems;
        this.purchasePrice = purchasePrice;
        this.id = UUID.randomUUID();

    }


    @Override
    public String toString() {
        var strBuilder = new StringBuilder("Order details: { order id: ")
                .append(id)
                .append("\n");
        orderedItems.forEach((item, amount) -> {
            strBuilder.append(item)
                    .append(": ")
                    .append(amount)
                    .append(" pieces\n")
                    .append("total price: ")
                    .append(purchasePrice)
                    .append("}");
        });
        return (orderedItems.size() > 0 ? strBuilder.toString() : "There is nothing in ordered items \n");
    }
}

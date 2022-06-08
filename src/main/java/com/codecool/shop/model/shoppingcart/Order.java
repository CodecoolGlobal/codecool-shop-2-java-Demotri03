package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public class Order {
    private Map<Product, Integer> orderedItems;
    private BigDecimal purchasePrice;


    public Order(Map<Product, Integer> orderedItems, BigDecimal purchasePrice) {
        this.orderedItems = orderedItems;
        this.purchasePrice = purchasePrice;
    }

    @Override
    public String toString() {
        var strBuilder = new StringBuilder("Order details: \n");

        orderedItems.forEach((item, amount) -> {
            strBuilder.append(item)
                    .append(": ")
                    .append(amount)
                    .append(" pieces\n");
        });
        return (orderedItems.size() > 0 ? strBuilder.toString() : "There is nothing in ordered items \n");
    }
}

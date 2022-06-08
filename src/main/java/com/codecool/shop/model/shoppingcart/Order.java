package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Order {
    protected Map<Product, Integer> LineItems= new HashMap<>();
    private BigDecimal price;

    public void addLineItem(Product product, Integer quantity) {
        //check if quantity is null
        if (quantity == null) {
            quantity = 1;
        }
        if (LineItems.containsKey(product)) {
            LineItems.put(product, LineItems.get(product) + quantity);
        } else {
            LineItems.put(product, quantity);
        }
        updatePrice();

    }
    public void removeLineItem(Product product) {
        LineItems.remove(product);
        updatePrice();
    }

    private void  updatePrice() {
        this.price = BigDecimal.ZERO;
        for (Product product : LineItems.keySet()) {
            this.price = this.price.add(product.getDefaultPrice().multiply(BigDecimal.valueOf(LineItems.get(product))));
        }
    }

    public BigDecimal getPrice() {
        return price;
    }


    public int getItemCount() {
        int ret=0;
        //iterate over the keys and values of lineitems
        for (Product product : LineItems.keySet()) {
            //count number of items
            ret+=LineItems.get(product);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Order{" +
                "LineItems=" + LineItems +
                ", price=" + price +
                '}';
    }
}

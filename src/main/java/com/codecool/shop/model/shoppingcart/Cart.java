package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    protected Map<Product, Integer> LineItems= new HashMap<>();
    private BigDecimal price;


//    private void  updatePrice() {
//        this.price = BigDecimal.ZERO;
//        for (Product product : LineItems.keySet()) {
//            this.price = this.price.add(product.getDefaultPrice().multiply(BigDecimal.valueOf(LineItems.get(product))));
//        }
//    }

    public BigDecimal getPrice() {
        return price;
    }

    public HashMap<Product, Integer> getLineItems() {
        return (HashMap<Product, Integer>) LineItems;
    }

//    public int getItemCount() {
//        int ret=0;
//        //iterate over the keys and values of lineitems
//        for (Product product : LineItems.keySet()) {
//            //count number of items
//            ret+=LineItems.get(product);
//        }
//        return ret;
//    }

    @Override
    public String toString() {
        return "Cart{" +
                "LineItems=" + LineItems +
                ", price=" + price +
                '}';
    }
}

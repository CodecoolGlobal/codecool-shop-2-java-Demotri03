package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.model.BaseModel;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart extends BaseModel {
    protected Map<Product, Integer> LineItems= new HashMap<>();
    private BigDecimal price;

    public Cart(String name) {
        super(name);
        this.price= BigDecimal.valueOf(0);
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

    public HashMap<Product, Integer> getLineItems() {
        return (HashMap<Product, Integer>) LineItems;
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

    public void addItem(Product product) {
        //if product is null, create a new product

        if (LineItems.containsKey(product)) {
            LineItems.put(product, LineItems.get(product));
        } else {
            LineItems.put(product, 1);
        }
        updatePrice();
        System.out.println(this);
        System.out.println("price: " + price);
    }

    public void remove(Product product) {
        if (LineItems.containsKey(product)) {
            LineItems.remove(product);
        }
        updatePrice();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "LineItems=" + LineItems +
                ", price=" + price +
                '}';
    }
}

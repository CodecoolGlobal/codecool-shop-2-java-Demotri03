package com.codecool.shop.model.shoppingcart;

import com.codecool.shop.model.BaseModel;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart extends BaseModel {
    protected Map<Product, Integer> LineItems= new HashMap<>();
    private BigDecimal price;
    User user;


    public Cart(String name, User user) {
        super(name);
        this.price= BigDecimal.valueOf(0);
        this.user = user;
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
    public void updateCart(int productId, boolean direction) {
        //iterate through cart lineitem
        System.out.println(direction + "ASDASDASD");
        for (Map.Entry<Product, Integer> entry : LineItems.entrySet()) {
            Product key = entry.getKey();
            Integer value = entry.getValue();
            if (key.getId() == productId) {
                if (direction) {
                    value++;
                } else {
                    value--;
                }
                if (value == 0) {
                    LineItems.remove(key);
                } else {
                    LineItems.put(key, value);
                }
            }
        }
    }




    public void addItem(Product product) {
        //if product is null, create a new product

        if (LineItems.containsKey(product)) {
            LineItems.put(product, LineItems.get(product) + 1);
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

    public List<List<String>> getReviewString(){
        List<List<String>> ret = new ArrayList<>();
        int total = this.price.intValue();
        for (Map.Entry<Product, Integer> entry : LineItems.entrySet()) {
            Product key = entry.getKey();
            Integer value = entry.getValue();
            List<String> data = new ArrayList<>();
            data.add(key.getName());
            data.add(value.toString());
            data.add(key.getPrice());
            String currency= key.getDefaultCurrency().toString();
            Integer number = key.getPriceForReview()*value;
            data.add(number +" "+currency);
            String id = String.valueOf(key.getId());
            data.add(id);
            data.add(this.user.toString());
            data.add("Cart value: "+total +" "+currency);
            ret.add(data);
        }
        return ret;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "LineItems=" + LineItems +
                ", price=" + price +
                '}';
    }
}

package com.codecool.shop.dao;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.shoppingcart.Cart;

import java.util.List;

public interface CartDao {
    void add(Cart order);
    Cart find(int id);
    void remove(int id);


    List<Cart> getAll();

}

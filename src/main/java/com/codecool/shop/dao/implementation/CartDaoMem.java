package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.shoppingcart.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartDaoMem implements CartDao {
    private List<Cart> data = new ArrayList<>();
    private static CartDaoMem instance = null;

    private CartDaoMem() {
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }


    @Override
    public void add(Cart order) {
//        data.setId(data.size() + 1);
//        data.add(order);

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void updatePrice() {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}

package com.codecool.shop.service;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.shoppingcart.Cart;

import java.util.List;

public class CartService {
    private CartDao cartDao;

    public CartService(CartDao cartDao) {
        this.cartDao= cartDao;
    }

    public Cart getCartById(int id) {
        System.out.println("cart: "+ cartDao.find(id));
        return cartDao.find(id);
    }


//    public List<Product> getProductsForCategory(int categoryId){
//        var category = productCategoryDao.find(categoryId);
//        return productDao.getBy(category);
//    }

}

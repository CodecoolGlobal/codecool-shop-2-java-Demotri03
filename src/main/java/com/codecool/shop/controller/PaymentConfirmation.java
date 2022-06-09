package com.codecool.shop.controller;


import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.shoppingcart.Cart;
import com.codecool.shop.model.user.Order;
import com.codecool.shop.model.user.User;
import com.codecool.shop.service.CartService;
import com.codecool.shop.service.ProductService;
import com.google.gson.Gson;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/order/payment/confirm"})
public class PaymentConfirmation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        CartService cartService = new CartService(CartDaoMem.getInstance());
    /*    TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
*/
        Cart cart = cartService.getCartById(1);
        Order order = new Order(cart);
        System.out.println( "total price: " + order.getPurchasePrice());
        User user = cart.getUser();
        System.out.println(user.toString());

        int confirmationCode;
        var typedAccount = req.getParameter("account");
        System.out.println(typedAccount);

        if (typedAccount.equals(String.valueOf(user.getCardNr()))) {
            user.getAccount().pay(order);
            if (order.isPayed()) {
                confirmationCode = 1;
                System.out.println(order.getPurchasePrice());

            } else {
                confirmationCode = 0;
                System.out.println(order.getPurchasePrice());

            }

        } else {
            confirmationCode = 5;
        }
        var out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.println(confirmationCode);

    }

}



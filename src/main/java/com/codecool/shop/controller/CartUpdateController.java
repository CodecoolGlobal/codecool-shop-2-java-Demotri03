package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.service.CartService;
import com.codecool.shop.service.ProductService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart/update"})
public class CartUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());


        ProductDao productDataStore = ProductDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();


        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        CartService cartService = new CartService(CartDaoMem.getInstance());

        System.out.println("startingcart: " + cartService.getCartById(1));

        String direction = "";
        Integer productId = 0;
        if (req.getParameter("productId") != null) {
             productId = Integer.parseInt(req.getParameter("productId"));
        }

        if (req.getParameter("direction") != null) {
             direction = (req.getParameter("direction"));

        }
        if (direction != null && productId != null) {
            boolean directionBool = false;
            if (direction.equals("plus")) {
                directionBool = true;
            }
            System.out.println("direction" + direction);
            cartService.getCartById(1).updateCart(productId, directionBool);

        }
        System.out.println("cart: " + cartService.getCartById(1));

        context.setVariable("cart", cartService.getCartById(1).getReviewString());
        engine.process("product/cart.html", context, resp.getWriter());
    }
}


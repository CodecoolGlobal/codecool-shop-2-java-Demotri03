package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.service.CartService;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.util.DaoSelector;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {
    private ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String chosenCategory = req.getParameter("category");
        String chosenSupplier = req.getParameter("supplier");

        productService = DaoSelector.getService();

        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        CartService cartService = new CartService(CartDaoMem.getInstance());
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        //ProductService productService = new ProductService(productDataStore,productCategoryDataStore,supplierDataStore);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        if (chosenSupplier == null) {
            filterByCategory(chosenCategory, productService, context);
        } else {
            filterBySupplier(chosenSupplier, productService, context);
        }

        context.setVariable("cart", cartService.getCartById(1));

        // // Alternative setting of the template context
        // Map<String, Object> params = new HashMap<>();
        // params.put("category", productCategoryDataStore.find(1));
        // params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));
        // context.setVariables(params);
        engine.process("product/index.html", context, resp.getWriter());
    }

    private void filterBySupplier(String chosenSupplier, ProductService productService, WebContext context) {
        int supplierId;
        switch (chosenSupplier) {
            case "chairFactory":
                supplierId = 1;
                break;
            case "ecoChair":
                supplierId = 2;
                break;
            case "yellowChairs":
                supplierId = 3;
                break;
            default:
                supplierId = 1;
            }
        context.setVariable("category", productService.getProductSupplier(supplierId));
        context.setVariable("products", productService.getProductsForSupplier(supplierId));
        logger.info("main page call by USER, chosen supplier: " + chosenSupplier);
    }

    private void filterByCategory(String chosenCategory, ProductService productService, WebContext context) {
        int categoryId;
        if (chosenCategory == null) {       //default category
            categoryId = 1;
            context.setVariable("category", productService.getProductCategory(categoryId));
            context.setVariable("products", productService.getProductsForCategory(categoryId));
            logger.info("default category - not parameterized main page call by USER");
        } else if (chosenCategory.equals("all")) {
            categoryId = 4;
            context.setVariable("category", productService.getProductCategory(categoryId));
            context.setVariable("products", productService.getAllProducts());
            logger.info("all products - chosen main page call by USER");
        } else {
            switch (chosenCategory) {
                case "metalChairs":
                    categoryId = 1;
                    break;
                case "woodChairs":
                    categoryId = 2;
                    break;
                case "otherChairs":
                    categoryId = 3;
                    break;
                default:
                    categoryId = 4;
            }
            context.setVariable("category", productService.getProductCategory(categoryId));
            context.setVariable("products", productService.getProductsForCategory(categoryId));
            logger.info("main page call by USER, chosen category: " + chosenCategory);
        }
    }

}
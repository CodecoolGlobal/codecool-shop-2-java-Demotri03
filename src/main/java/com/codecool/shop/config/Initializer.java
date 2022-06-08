package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier chairFactory = new Supplier("Chair Factory Co.", "Coolest chairs on the planet.");
        supplierDataStore.add(chairFactory);
        Supplier ecoChair = new Supplier("Eco Chairs Limited", "Environment friendly chairs.");
        supplierDataStore.add(ecoChair);
        Supplier yellowChairs = new Supplier("Yellow Chairs Company", "Only yellow chairs.");
        supplierDataStore.add(ecoChair);

        //setting up a new product category
//        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
//        productCategoryDataStore.add(tablet);
        ProductCategory metalChair = new ProductCategory("Metal chairs", "MetalDepartment", "A chair made of metal. Usually can support heavy people. Easy to clean. Minimalist design.");
        productCategoryDataStore.add(metalChair);
        ProductCategory woodChair = new ProductCategory("Wooden chairs", "WoodDepartment", "A chair made of wood. Max for 100 kg weight. Clean with caution. Modern design.");
        productCategoryDataStore.add(woodChair);
        ProductCategory otherChair = new ProductCategory("Other type of chairs", "OtherDepartment", "A chair made of plastic or other fabric. Clean carefully. Various design.");
        productCategoryDataStore.add(otherChair);
        ProductCategory allChairs = new ProductCategory("All of the available chairs", "AllDepartment", "All of the chairs");
        productCategoryDataStore.add(allChairs);

        //setting up products and printing it
        productDataStore.add(new Product("Organic Metal 300", new BigDecimal("302.9"), "USD", "Stackable chair with armrests, made using natural materials and artisanal processes.", metalChair, chairFactory));

        productDataStore.add(new Product("Cosy Yellow Miix", new BigDecimal("461.6"), "USD", "The shearling-style fabric is the ideal way to add warmth, style and contemporary chic to your space.", otherChair, yellowChairs));
        productDataStore.add(new Product("The blue zone", new BigDecimal("299.9"), "USD", "Upholstered in shearling-style fabric", otherChair, ecoChair));
        productDataStore.add(new Product("Yellow Metal Classic 66", new BigDecimal("479.3"), "USD", "The shearling-style fabric is the ideal way to add warmth, style and contemporary chic to your space.", metalChair, yellowChairs));
        productDataStore.add(new Product("Straight Lines 700", new BigDecimal("479.3"), "USD", "Metal structure with matt black painted finish.", metalChair, chairFactory));
        productDataStore.add(new Product("The Ring", new BigDecimal("89.8"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", metalChair, ecoChair));

        productDataStore.add(new Product("Hanging Chill New", new BigDecimal("1999.5"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", metalChair, chairFactory));
        productDataStore.add(new Product("Black Lines 2 pieces", new BigDecimal("3566"), "USD", "Metal structure with matt black painted finish.", metalChair, ecoChair));
        productDataStore.add(new Product("Support my Back", new BigDecimal("299.9"), "USD", "The shearling-style fabric is the ideal way to add warmth, style and contemporary chic to your space.", woodChair, ecoChair));
        productDataStore.add(new Product("Floating Feeling", new BigDecimal("4248"), "USD", "The frame is made from solid acacia wood with natural finish, offering unique tones and grain patterns in every piece", woodChair, chairFactory));
        productDataStore.add(new Product("Number Five 55555", new BigDecimal("479.3"), "USD", "Cares design: with an internal wooden structure made with zero-emission adhesives to keep the planet free from pollution", woodChair, chairFactory));
        productDataStore.add(new Product("Wooden Chair is my Name", new BigDecimal("89.8"), "USD", "The wood sourced is from sustainably-managed forests, where felling is controlled to protect the environment.", woodChair, ecoChair));

        productDataStore.add(new Product("Curvy Dream 2022", new BigDecimal("1999.5"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", woodChair, chairFactory));
        productDataStore.add(new Product("Tha Oval Set", new BigDecimal("3566"), "USD", "The frame is made from solid acacia wood with natural finish, offering unique tones and grain patterns in every piece", woodChair, ecoChair));
        productDataStore.add(new Product("Yellow Slices Beta", new BigDecimal("299.9"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", otherChair, yellowChairs));
        productDataStore.add(new Product("The ventilator", new BigDecimal("4248"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", otherChair, yellowChairs));
        productDataStore.add(new Product("Sit with Me", new BigDecimal("479.3"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", otherChair, chairFactory));
        productDataStore.add(new Product("Coffee Chair", new BigDecimal("89.8"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", otherChair, ecoChair));

        productDataStore.add(new Product("Black to Basics", new BigDecimal("4248"), "USD", "Stackable chair with armrests, made using natural materials and artisanal processes.", otherChair, ecoChair));
        productDataStore.add(new Product("Butterfly 888", new BigDecimal("479.3"), "USD", "Upholstered in shearling-style fabric", otherChair, yellowChairs));
        productDataStore.add(new Product("The Desert Cactus ", new BigDecimal("89.8"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", otherChair, yellowChairs));
        productDataStore.add(new Product("Metal Bar Chair 24", new BigDecimal("1258"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", metalChair, chairFactory));
        productDataStore.add(new Product("Yellow Wooden Rocking Chair", new BigDecimal("89.8"), "USD", "Cares design: with an internal wooden structure made with zero-emission adhesives to keep the planet free from pollution", woodChair, yellowChairs));
    }
}

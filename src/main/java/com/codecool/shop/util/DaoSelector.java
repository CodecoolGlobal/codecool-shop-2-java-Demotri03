package com.codecool.shop.util;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.Jdbc.ProductCategoryJdbc;
import com.codecool.shop.dao.Jdbc.ProductJdbc;
import com.codecool.shop.dao.Jdbc.SupplierJdbc;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.service.ProductService;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class DaoSelector {
    private static ProductCategoryDao ProductCategoryDao;
    private static ProductDao ProductDao;
    private static SupplierDao SupplierDao;
    private static CartDao CartDao;
    private static Properties properties = new Properties();


    public static ProductService getService() throws IOException {
        properties.load(new FileInputStream("src/main/resources/connection.properties"));
        if(properties.getProperty("dao").equals("jdbc")){
            try {
                System.out.println("I'm in jdbc service");
                DataSource dataSource = connect();
                ProductCategoryDao = new ProductCategoryJdbc(dataSource);
                SupplierDao = new SupplierJdbc(dataSource);
                ProductDao = new ProductJdbc(dataSource, ProductCategoryDao, SupplierDao);

            } catch (SQLException e) {
                System.err.println("Database connection unavailable!");
            }
        }
        else if (properties.getProperty("dao").equals("memory")) {
            System.out.println("I'm in old memory service");
            ProductDao = ProductDaoMem.getInstance();
            ProductCategoryDao = ProductCategoryDaoMem.getInstance();
            SupplierDao = SupplierDaoMem.getInstance();
        }
        return new ProductService(ProductDao, ProductCategoryDao, SupplierDao);
    }


    public static DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName(properties.getProperty("db_name"));
        dataSource.setUser(properties.getProperty("db_user"));
        dataSource.setPassword(properties.getProperty("db_password"));
        System.out.println("Trying to connect...");
        dataSource.getConnection().close();
        System.out.println("Connection OK");

        return dataSource;
    }
}
package com.codecool.shop.dao.Jdbc;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductJdbc implements ProductDao {
    private DataSource dataSource;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;

    public ProductJdbc(DataSource dataSource, ProductCategoryDao productCategoryDao, SupplierDao supplierDao){
        this.dataSource = dataSource;
        this.productCategoryDao = productCategoryDao;
        this.supplierDao = supplierDao;
    }

    @Override
    public void add(Product product) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO products(name, price, currency, description, categoryID, supplierID, imageRoute) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setBigDecimal(2, product.getDefaultPrice());
            statement.setString(3, String.valueOf(product.getDefaultCurrency()));
            statement.setString(4, product.getDescription());
            statement.setInt(5, product.getProductCategory().getId());
            statement.setInt(6, product.getSupplier().getId());
            statement.setString(7, product.getImage());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Product find(int id) {
        try(Connection connection = dataSource.getConnection()){
            String sql = "SELECT * FROM products WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next()){
                return null;
            }
            return createProduct(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void remove(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {
        try(Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM products";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            List<Product> products = new ArrayList<>();
            while(resultSet.next()){
                products.add(createProduct(resultSet));
            }
            return products;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        try(Connection connection = dataSource.getConnection()){
            String sql = "SELECT p.* FROM products p JOIN suppliers s ON p.supplierID = s.id WHERE s.id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, supplier.getId());
            ResultSet resultSet = statement.executeQuery();

            List<Product> products = new ArrayList<>();
            while(resultSet.next()){
                products.add(createProduct(resultSet));
            }
            return products;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        try(Connection connection = dataSource.getConnection()){
            String sql = "SELECT p.* FROM products p JOIN productcategories c ON p.categoryID = c.id WHERE c.id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productCategory.getId());
            ResultSet resultSet = statement.executeQuery();

            List<Product> products = new ArrayList<>();
            while(resultSet.next()){
                products.add(createProduct(resultSet));
            }
            return products;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    private Product createProduct(ResultSet resultSet) throws SQLException {
        int categoryId = resultSet.getInt(6);
        ProductCategory productCategory = productCategoryDao.find(categoryId);

        int supplierId = resultSet.getInt(7);
        Supplier supplier = supplierDao.find(supplierId);

        Product product = new Product(
                resultSet.getString(2),
                resultSet.getBigDecimal(3),
                resultSet.getString(4),
                resultSet.getString(5),
                productCategory, supplier, resultSet.getString(8));
        product.setId(resultSet.getInt(1));
        return product;
    }
}
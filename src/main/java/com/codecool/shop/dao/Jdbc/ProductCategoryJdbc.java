package com.codecool.shop.dao.Jdbc;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryJdbc implements ProductCategoryDao {
    private DataSource dataSource;

    private static final Logger logger = LoggerFactory.getLogger(ProductCategoryJdbc.class);

    public ProductCategoryJdbc(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void add(ProductCategory category) {
        logger.debug("add ProductCategory called");
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO productcategories(name, department, description) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.getName());
            statement.setString(2, category.getDepartment());
            statement.setString(3, category.getDescription());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Database insert failed");
        }
    }

    @Override
    public ProductCategory find(int id) {
        logger.debug("find ProductCategory called");
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM productcategories WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next()) {
                return null;
            }

            ProductCategory category = new ProductCategory(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            category.setId(resultSet.getInt(1));
            return category;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Database select failed");
            return null;
        }
    }

    @Override
    public void remove(int id) {
        logger.debug("remove ProductCategory called");
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM productcategories WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Database delete failed");
        }

    }

    @Override
    public List<ProductCategory> getAll() {
        logger.debug("get all ProductCategory called");
        try(Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM productcategories";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            List<ProductCategory> categories = new ArrayList<>();
            while(resultSet.next()){
                ProductCategory category = new ProductCategory(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                category.setId(resultSet.getInt(1));
                categories.add(category);
            }
            return categories;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Database select failed");
            return null;
        }
    }
}
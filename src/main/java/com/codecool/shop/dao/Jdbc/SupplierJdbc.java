package com.codecool.shop.dao.Jdbc;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierJdbc implements SupplierDao {
    private DataSource dataSource;

    public SupplierJdbc(DataSource dataSource){
        this.dataSource = dataSource;
    }
    private static final Logger logger = LoggerFactory.getLogger(SupplierJdbc.class);

    @Override
    public void add(Supplier supplier) {
        logger.debug("add Supplier called");
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO suppliers(name, description) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getDescription());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Database insert failed");
        }
    }

    @Override
    public Supplier find(int id) {
        logger.debug("find Supplier called");
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM suppliers WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next()){
                return null;
            }

            Supplier supplier = new Supplier(resultSet.getString(2), resultSet.getString(3));
            supplier.setId(resultSet.getInt(1));
            return supplier;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Database select failed");
            return null;
        }
    }

    @Override
    public void remove(int id) {
        logger.debug("remove Supplier called");
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM suppliers WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Database delete failed");
        }
    }

    @Override
    public List<Supplier> getAll() {
        logger.debug("get all Supplier called");
        try(Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM suppliers";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            List<Supplier> suppliers = new ArrayList<>();
            while(resultSet.next()){
                Supplier supplier = new Supplier(resultSet.getString(2), resultSet.getString(3));
                supplier.setId(resultSet.getInt(1));
                suppliers.add(supplier);
            }
            return suppliers;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Database select failed");
            return null;
        }
    }
}
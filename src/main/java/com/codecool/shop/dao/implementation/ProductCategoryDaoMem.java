package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoMem implements ProductCategoryDao {

    private List<ProductCategory> data = new ArrayList<>();
    private static ProductCategoryDaoMem instance = null;
    private static final Logger logger = LoggerFactory.getLogger(ProductCategoryDaoMem.class);

    /* A private Constructor prevents any other class from instantiating.
     */
    private ProductCategoryDaoMem() {
    }

    public static ProductCategoryDaoMem getInstance() {
        if (instance == null) {
            instance = new ProductCategoryDaoMem();

        }
        return instance;
    }

    @Override
    public void add(ProductCategory category) {
        logger.debug("add ProductCategory called");
        category.setId(data.size() + 1);
        data.add(category);
        //System.out.println(data);
    }

    @Override
    public ProductCategory find(int id) {
        logger.debug("find ProductCategory called");
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        logger.debug("remove ProductCategory called");
        data.remove(find(id));
    }

    @Override
    public List<ProductCategory> getAll() {
        logger.debug("get all ProductCategory called");
        return data;
    }
}

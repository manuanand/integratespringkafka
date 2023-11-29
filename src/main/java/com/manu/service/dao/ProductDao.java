package com.manu.service.dao;

import com.manu.service.event.Product;
import com.manu.service.event.database.ProductInformation;
import com.manu.service.repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDao {

    private static final Logger logger = LoggerFactory.getLogger(Product.class);

    private final ProductRepository dataBaseObject;

    public ProductDao(ProductRepository dataBaseObject) {
        this.dataBaseObject = dataBaseObject;
    }

    public void insertProductData(ProductInformation product) {
        try {
           dataBaseObject.save(product);
           logger.info("Product information successfully saved to database");
        } catch (Exception e) {
            logger.error("Could not save Product information to database");
        }
    }

    public Optional<List<ProductInformation>> getAllProduct() {
        try {
            return Optional.of(dataBaseObject.findAll());
        } catch (Exception e) {
            return Optional.empty();
        }

    }
}

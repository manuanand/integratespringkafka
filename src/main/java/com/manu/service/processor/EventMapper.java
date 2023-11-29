package com.manu.service.processor;

import com.manu.service.event.Product;
import com.manu.service.event.database.ProductInformation;

import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public ProductInformation mapProductToProductInformation(Product product) {
    	ProductInformation productInformation = new ProductInformation();
    	
    	productInformation.setId(product.getId());
    	productInformation.setProductId(product.getProductId());
    	productInformation.setProductName(product.getProductName());
    	productInformation.setProductPrice(product.getProductPrice());
        return productInformation;
    }
}

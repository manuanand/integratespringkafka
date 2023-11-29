package com.manu.service.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Product.Builder.class)
public class Product {

	private final String id;
    private final String productName;
    private final int productId;
    private final int productPrice;

    public String getId() {
		return id;
	}



	public String getProductName() {
		return productName;
	}



	public int getProductId() {
		return productId;
	}



	public int getProductPrice() {
		return productPrice;
	}
    
    private Product(Builder builder) {
        id = builder.id;
        productName = builder.productName;
        productId = builder.productId;
        productPrice = builder.productPrice;

    }
   

    public static class Builder {
        private String id;
        private String productName;
        private int productId;
        private int productPrice;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder withProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public Builder withProductPrice(int productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

}
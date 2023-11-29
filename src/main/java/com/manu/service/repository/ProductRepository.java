package com.manu.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.manu.service.event.database.ProductInformation;

@Repository
public interface ProductRepository extends MongoRepository<ProductInformation, String> {
}

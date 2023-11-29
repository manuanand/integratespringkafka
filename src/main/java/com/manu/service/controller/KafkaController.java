package com.manu.service.controller;

import com.manu.service.dao.ProductDao;
import com.manu.service.event.Product;
import com.manu.service.event.database.ProductInformation;
import com.manu.service.producer.KafkaProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaProducer producer;
    private final ProductDao productDao;

    public KafkaController(KafkaProducer producer, ProductDao productDao) {
        this.producer = producer;
        this.productDao = productDao;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody Product productInformation) {
        logger.info("Received request");
        producer.sendMessage(productInformation);
    }

    @GetMapping(value = "/all/events")
    public List<ProductInformation> getAllProductFromDatabase() {
        Optional<List<ProductInformation>> productInformation = productDao.getAllProduct();
        if (!productInformation.isPresent()) {
            logger.debug("No data present in database");
        } else {
            logger.info("Received List of Product data");
        }
        return productInformation.get();
    }
}

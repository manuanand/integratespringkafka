package com.manu.service.consumer;

import com.manu.service.dao.ProductDao;
import com.manu.service.event.Product;
import com.manu.service.event.database.ProductInformation;
import com.manu.service.processor.EventMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    private ProductDao productDao = null;
    private final EventMapper eventMapper;

    public KafkaConsumer(ProductDao productDao, EventMapper eventMapper) {
        this.productDao = productDao;
        this.eventMapper = eventMapper;
    }

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "group_id")
    public void consume(@Payload Product product) {
        logger.info("Consumed Message from show -> {}", product.getProductName());
        ProductInformation protagonistInformation = eventMapper.mapProductToProductInformation(product);
        productDao.insertProductData(protagonistInformation);
        logger.info("Message received from consumer 1");
    }
}

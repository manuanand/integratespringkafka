package com.manu.service.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.manu.service.event.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Product product){
        try {
            logger.info("Publishing Product with name: {} ",product.getProductName() );
            kafkaTemplate.sendDefault(product);
            kafkaTemplate.flush();
            logger.info("Message successfully published to kafka");
        } catch (Exception e) {
            logger.info("Failed to publish message to kafka");
            e.printStackTrace();
        }
    }

}

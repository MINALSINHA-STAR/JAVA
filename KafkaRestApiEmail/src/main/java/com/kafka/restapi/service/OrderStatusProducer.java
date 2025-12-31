package com.kafka.restapi.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import com.kafka.restapi.request.OrderStatusEvent;


@Service
public class OrderStatusProducer {

    private static final String TOPIC = "orderCart02";
    private final KafkaProducer<String, String> producer;

    public OrderStatusProducer() {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        this.producer = new KafkaProducer<>(props);
    }

    public void sendOrderStatus(OrderStatusEvent event) {

        
        String message =
                event.getOrderId() + "|" +
                event.getEmail() + "|" +
                event.getStatus();

        ProducerRecord<String, String> record =
                new ProducerRecord<>(TOPIC, event.getOrderId(), message);

        producer.send(record);

        System.out.println("Produced: " + message);
    }
}


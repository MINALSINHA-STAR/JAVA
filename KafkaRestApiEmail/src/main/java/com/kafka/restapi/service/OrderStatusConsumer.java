package com.kafka.consumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

public class OrderStatusConsumer {

	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		prop.put(ConsumerConfig.GROUP_ID_CONFIG, "order-email-consumer");
		prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);
		consumer.subscribe(Collections.singletonList("orderCart02"));

		System.out.println("Kafka Email Consumer started...");

		while (true) {

			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

			for (ConsumerRecord<String, String> record : records) {

				String[] parts = record.value().split("\\|");

				String orderId = parts[0];
				String email = parts[1];
				String status = parts[2];

				String subject = "Order Status Update – " + orderId;

				String body = "Dear Customer,\n\n" + "Your order status has been updated.\n\n" + "Order ID : " + orderId
						+ "\n" + "Status   : " + status + "\n\n" + "Your order is delivered successfully";

				//EmailUtil.sendMail(email, subject, body);

				System.out.println("Email sent | orderId=" + orderId + " | partition=" + record.partition()
						+ " | offset=" + record.offset());
			}
		}
	}
}

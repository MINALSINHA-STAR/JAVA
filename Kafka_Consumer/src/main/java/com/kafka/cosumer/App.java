package com.kafka.cosumer;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


public class App {
	public static void main(String[] args)

	{
		//1. configuration of the Consumer(Host, Group Id, serializer/Deserializer)
		Properties prop = new Properties();
		prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		prop.put(ConsumerConfig.GROUP_ID_CONFIG, "order-db-group");
		prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		//2. Create Kafka Consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer(prop);
		
		//3. To subscribe the topic
		consumer.subscribe(Collections.singletonList("orderCart02"));
		//4. poll the topic  
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
			for(ConsumerRecord record: records) {
				
				//System.out.println("timestamp "+record.timestamp());
				System.out.println("message topic: "+record.topic());
				System.out.println("msg partition: "+record.partition());
				System.out.println("msg offset: "+record.offset());
				System.out.println("msg key: "+record.key());
				System.out.println("msg value: "+record.value());
				System.out.println("Records fetched: " + records.count());

				
			}
		}
		
	
	}
}

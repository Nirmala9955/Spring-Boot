package com.sahu.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class MessageProducer {

	public static void main(String[] args) {
		//Create connection properties as K=V in java.util.Properties class object
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		//Create KafkaProducer object
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		//Create ProducerRecord representing the message
		String message = "Welcome to Apache Kafkas Message";
		String topicName = "sahu-tpc-may";
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, message);
		//Send message (record) 
		producer.send(record);
		//flush the message
		producer.flush();
		//close the connection with bootstrap server
		producer.close();
		System.out.println("Message sent.");
	}
	
}

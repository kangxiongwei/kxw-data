package com.kxw.data.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Create by kangxiongwei on 2019/5/19 10:21 AM
 */
public class KafkaDataProducer<K, V> {

    /**
     * 生产消息到kafka队列中
     *
     * @param topic
     * @param key
     * @param value
     */
    public void sendMessage(String topic, K key, V value) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<K, V> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>(topic, key, value));
        producer.close();
    }


}

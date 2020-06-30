package org.blade.demo.kafkawithspringboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public abstract class Producer<T extends Object> {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    protected KafkaTemplate<String, T> kafkaTemplate;

    abstract protected String getTopic();

    public void sendMessage(T obj) {
        logger.info(String.format("#### -> Producing message -> %s", obj.toString()));
        this.kafkaTemplate.send(getTopic(), obj);
    }

}
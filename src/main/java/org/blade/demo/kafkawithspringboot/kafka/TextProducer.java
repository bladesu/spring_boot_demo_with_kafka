package org.blade.demo.kafkawithspringboot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TextProducer extends Producer<String> {

    @Value("${mq_txt.topic}")
    protected String topic;

    @Autowired
    public TextProducer() {
        super();
    }

    @Override
    protected String getTopic() {
        return topic;
    }

}
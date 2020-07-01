package org.blade.demo.kafkawithspringboot.kafka;

import org.blade.demo.kafkawithspringboot.model.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@PropertySource("application-img.yml")
public class FilSysImgProducer {

    private static final Logger logger = LoggerFactory.getLogger(FilSysImgProducer.class);

    @Autowired
    protected KafkaTemplate<String, byte[]> kafkaTemplate;

    @Value("${mq_img.topic}")
    protected String topic;

    @Autowired
    public FilSysImgProducer() {
        super();
    }

    protected String getTopic() {
        return topic;
    }

    public void sendMessage(Image obj) {
        logger.info(String.format("#### -> Producing message -> %s", obj.getId()));
        this.kafkaTemplate.send(getTopic(), obj.getData());
    }

}
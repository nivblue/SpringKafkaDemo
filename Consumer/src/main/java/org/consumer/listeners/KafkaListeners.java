package org.consumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.sharedobjects.kafka.BasicMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class KafkaListeners {
    @KafkaListener(topics = "TEST_TOPIC", groupId = "groupId")
    void listener(BasicMessage data) {
        log.debug("data received as basic message : " + data.message());
    }
}
